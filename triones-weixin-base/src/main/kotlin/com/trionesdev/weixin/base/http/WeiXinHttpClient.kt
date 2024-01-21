package com.trionesdev.weixin.base.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.model.BaseResponse
import okhttp3.OkHttpClient
import okhttp3.Request

class WeiXinHttpClient {
    companion object {
        const val BASE_URL: String = "https://api.weixin.qq.com/"
    }

    var httpClient: OkHttpClient = OkHttpClient.Builder().build();
    var weiXinConfig: WeiXinConfig

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) {
        this.weiXinConfig = weiXinConfig
        httpClient?.let { t -> this.httpClient = t }
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
        return ObjectMapper().readValue(res.body?.string(), R::class.java)
    }

    fun urlFormat(url: String): String {
        return "${BASE_URL}${if (url.startsWith("/")) url.substring(1) else url}"
    }

}