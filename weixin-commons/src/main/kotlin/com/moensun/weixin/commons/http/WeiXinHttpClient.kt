package com.moensun.weixin.commons.http

import com.alibaba.fastjson.JSON
import com.moensun.weixin.commons.WeiXinConfig
import okhttp3.OkHttpClient
import okhttp3.Request

abstract class WeiXinHttpClient {
    companion object {
        const val BASE_URL: String = "https://api.weixin.qq.com/"
    }

    var httpClient: OkHttpClient
    var weiXinConfig: WeiXinConfig

    constructor(weiXinConfig: WeiXinConfig) {
        this.weiXinConfig = weiXinConfig
        this.httpClient = OkHttpClient()
    }

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient) {
        this.weiXinConfig = weiXinConfig
        this.httpClient = httpClient
    }

    fun appId(): String? {
        return weiXinConfig.appId
    }

    inline fun <reified R : BaseResponse?, A : HttpRequest?> doExecute(request: A): R {
        val requestBuilder = Request.Builder()
        request?.let { t ->
            requestBuilder.url(urlFormat(t.url!!)).headers(t.headers)
        }
        when (request?.method) {
            HttpMethod.GET -> requestBuilder.get()
            HttpMethod.POST -> requestBuilder.method(HttpMethod.POST.name, request.body)
            HttpMethod.PUT -> requestBuilder.method(HttpMethod.PUT.name, request.body)
            HttpMethod.DELETE -> requestBuilder.delete(request.body)
            else -> {
                requestBuilder.get()
            }
        }
        val res = httpClient.newCall(requestBuilder.build()).execute()
        return JSON.parseObject(res.body?.string(), R::class.java)
    }

    //region 接口调用凭证
    /**
     * 获取小程序全局唯一后台接口调用凭据
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html
     */
    fun getAccessToken(): AccessTokenResponse {
        val request = HttpRequest.Builder().get()
            .url("cgi-bin/token?grant_type=client_credential&appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}")
            .build()
        return doExecute(request)
    }
    //endregion


    protected fun accessToken(accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinConfig.weiXinCache?.let {
                return it.accessToken()
            } ?: let {
                return getAccessToken().accessToken
            }
        }
    }


    fun urlFormat(url: String): String {
        return "${BASE_URL}${if (url.startsWith("/")) url.substring(1) else url}"
    }

}