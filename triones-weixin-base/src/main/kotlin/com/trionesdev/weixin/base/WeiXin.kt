package com.trionesdev.weixin.base

import com.trionesdev.weixin.base.model.AccessTokenResponse
import com.trionesdev.weixin.base.model.BaseResponse
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.http.WeiXinHttpClient
import okhttp3.OkHttpClient

abstract class WeiXin : WeXinTemplate {
    var weiXinConfig: WeiXinConfig
    protected var wxHttpClient: WeiXinHttpClient

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) {
        this.weiXinConfig = weiXinConfig
        wxHttpClient = WeiXinHttpClient(weiXinConfig, httpClient)
    }

    override fun appId(): String? {
        return weiXinConfig.appId
    }

    protected inline fun <reified R : BaseResponse?, A : HttpRequest?> doExecute(request: A): R {
        return wxHttpClient.doExecute(request)
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
        weiXinConfig.weiXinCache?.setAccessToken(weiXinConfig.appId, res.accessToken, res.expiresIn)
        return res
    }
    //endregion


    fun accessToken(accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinConfig.weiXinCache?.let {
                return it.getAccessToken(weiXinConfig.appId)
            } ?: let {
                return getAccessToken().accessToken
            }
        }
    }
}