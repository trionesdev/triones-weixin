package com.moensun.weixin.commons.http

import com.alibaba.fastjson.JSON
import com.moensun.weixin.commons.BaseResponse
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

    fun urlFormat(url: String): String {
        return "${BASE_URL}${if (url.startsWith("/")) url.substring(1) else url}"
    }

}