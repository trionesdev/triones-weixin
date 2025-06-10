package com.trionesdev.weixin.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.Lists
import com.trionesdev.weixin.base.ex.WeiXinException
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.http.WeiXinHttpClient
import com.trionesdev.weixin.base.model.AccessTokenResponse
import com.trionesdev.weixin.base.model.BaseResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.apache.commons.collections4.CollectionUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.function.BinaryOperator
import java.util.function.Function
import java.util.stream.Collectors

abstract class WeiXin : WeXinTemplate {
    var logger: Logger = LoggerFactory.getLogger(WeiXin::class.java)
    var weiXinConfig: WeiXinConfig

    /**
     * 当是多个微信账户配置时候，组成以appId为key的map
     */
    var weiXinCredentialsMap: Map<String, WeiXinCredentials>?
    protected var wxHttpClient: WeiXinHttpClient
    var weiXinCache: WeiXinCache?

    fun buildWeiXinCredentialsMap(weiXinConfig: WeiXinConfig): MutableMap<String, WeiXinCredentials>? {
        return weiXinConfig.credentials?.values?.stream()?.collect(
            Collectors.toMap(
                WeiXinCredentials::appId,
                Function { v: WeiXinCredentials -> v },
                BinaryOperator { a: WeiXinCredentials, b: WeiXinCredentials -> a })
        )
    }

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) {
        this.weiXinConfig = weiXinConfig
        this.weiXinCredentialsMap = buildWeiXinCredentialsMap(weiXinConfig)
        wxHttpClient = WeiXinHttpClient(weiXinConfig, httpClient)
        weiXinCache = weiXinConfig.cache
    }

    /**
     * 获取默认的AppId
     */
    override fun appId(): String? {
        return weiXinConfig.appId
    }

    /**
     * 根据key获取对应的通行证信息
     */
    override fun getCredentials(key: String): WeiXinCredentials?{
        return weiXinConfig.credentials?.get(key)
    }

    /**
     * 获取微信配置，如果请求时带上了appId，则从map中取对应的微信账户凭证信息
     */
    fun weiXinCredentials(appId: String?): WeiXinCredentials {
        return appId?.let { weiXinCredentialsMap?.get(appId) } ?: let { weiXinConfig }
    }

    protected inline fun <reified R : BaseResponse?, A : HttpRequest?> doExecute(request: A): R {
        val res: R = wxHttpClient.doExecute(request)
        if (res?.errorCode != null && res.errorCode != 0L) {
            logger.error("errorCode:{},errorMsg:{}", res.errorCode, res.errorMsg)
            throw WeiXinException(res.errorCode.toString(), res.errorMsg ?: let { "" })
        }
        return res
    }

    protected fun <A : HttpRequest?> doExecuteSimple(request: A): ResponseBody? {
        val body = wxHttpClient.doExecuteSimple(request)
        if (!CollectionUtils.containsAny(Lists.newArrayList("image"), body?.contentType()?.type)) {
            val res = ObjectMapper().readValue(body.toString(), BaseResponse::class.java)
            if (res?.errorCode != null && res.errorCode != 0L) {
                logger.error("errorCode:{},errorMsg:{}", res.errorCode, res.errorMsg)
                throw WeiXinException(res.errorCode.toString(), res.errorMsg ?: let { "" })
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
    override fun getAccessToken(appId: String?): AccessTokenResponse {
        val weiXinCredentials = weiXinCredentials(appId)
        val request = HttpRequest.Builder().get()
            .url("cgi-bin/token?grant_type=client_credential&appid=${weiXinCredentials.appId}&secret=${weiXinCredentials.secret}")
            .build()
        val res: AccessTokenResponse = doExecute(request)
        weiXinCache?.setAccessToken(weiXinCredentials.appId, res.accessToken, res.expiresIn)
        return res
    }
    //endregion


    fun accessToken(appId: String?, accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinCache?.let {
                return it.getAccessToken( appId) ?: let {
                    return getAccessToken(appId).accessToken
                }
            } ?: let {
                return getAccessToken(appId).accessToken
            }
        }
    }
}