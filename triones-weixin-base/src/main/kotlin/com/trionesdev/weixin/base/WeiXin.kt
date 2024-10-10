package com.trionesdev.weixin.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.Lists
import com.trionesdev.weixin.base.ex.WeiXinException
import com.trionesdev.weixin.base.model.AccessTokenResponse
import com.trionesdev.weixin.base.model.BaseResponse
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.http.WeiXinHttpClient
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.apache.commons.collections4.CollectionUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class WeiXin : WeXinTemplate {
    var logger: Logger = LoggerFactory.getLogger(WeiXin::class.java)
    var weiXinConfig: WeiXinConfig
    protected var wxHttpClient: WeiXinHttpClient
    var weiXinCache: WeiXinCache?

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) {
        this.weiXinConfig = weiXinConfig
        wxHttpClient = WeiXinHttpClient(weiXinConfig, httpClient)
        weiXinCache = weiXinConfig.weiXinCache
    }

    override fun appId(): String? {
        return weiXinConfig.appId
    }

    protected inline fun <reified R : BaseResponse?, A : HttpRequest?> doExecute(request: A): R {
        val res: R = wxHttpClient.doExecute(request)
        if (res?.errorCode != null && res.errorCode != 0L) {
            logger.error("errorCode:{},errorMsg:{}", res.errorCode, res.errorMsg)
            throw WeiXinException(res.errorCode.toString(), res.errorMsg)
        }
        return res
    }

    protected fun <A : HttpRequest?> doExecuteSimple(request: A): ResponseBody? {
        val body = wxHttpClient.doExecuteSimple(request)
        if (!CollectionUtils.containsAny(Lists.newArrayList("image"), body?.contentType()?.type)) {
            val res = ObjectMapper().readValue(body.toString(), BaseResponse::class.java)
            if (res?.errorCode != null && res.errorCode != 0L) {
                logger.error("errorCode:{},errorMsg:{}", res.errorCode, res.errorMsg)
                throw WeiXinException(res.errorCode.toString(), res.errorMsg)
            } else {
                return body
            }
        } else {
            return body
        }
    }

    //region 接口调用凭证
    /**
     * 获取小程序全局唯一后台接口调用凭据
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html
     */
    override fun getAccessToken(): AccessTokenResponse {
        val request = HttpRequest.Builder().get()
            .url("cgi-bin/token?grant_type=client_credential&appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}")
            .build()
        val res: AccessTokenResponse = doExecute(request)
        weiXinCache?.setAccessToken(weiXinConfig.appId, res.accessToken, res.expiresIn)
        return res
    }
    //endregion


    fun accessToken(accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinCache?.let {
                return it.getAccessToken(weiXinConfig.appId) ?: let {
                    return getAccessToken().accessToken
                }
            } ?: let {
                return getAccessToken().accessToken
            }
        }
    }
}