package com.trionesdev.weixin.base

import com.trionesdev.weixin.base.ex.WeiXinException
import com.trionesdev.weixin.base.model.AccessTokenResponse
import com.trionesdev.weixin.base.model.BaseResponse
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.http.WeiXinHttpClient
import okhttp3.OkHttpClient
import org.slf4j.LoggerFactory

abstract class WeiXin : WeXinTemplate {
    var LOGGER = LoggerFactory.getLogger(WeiXin::class.java)
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
        if (res?.errorCode != null) {
            LOGGER.error("errorCode:{},errorMsg:{}", res.errorCode, res.errorMsg)
            throw WeiXinException(res.errorCode.toString(), res.errorMsg)
        }
        return res
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