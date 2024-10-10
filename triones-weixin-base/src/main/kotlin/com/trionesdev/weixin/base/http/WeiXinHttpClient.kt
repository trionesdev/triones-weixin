package com.trionesdev.weixin.base.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.ex.WeiXinException
import com.trionesdev.weixin.base.model.BaseResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor

class WeiXinHttpClient {
    companion object {
        const val BASE_URL: String = "https://api.weixin.qq.com/"
    }

    var httpClient: OkHttpClient = OkHttpClient.Builder().build();
    var weiXinConfig: WeiXinConfig

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, client: OkHttpClient?) {
        this.weiXinConfig = weiXinConfig
        client?.let { t -> this.httpClient = t }
        weiXinConfig.httpLogLevel?.let { levelIt ->
            this.httpClient =
                this.httpClient.newBuilder().addInterceptor(HttpLoggingInterceptor().apply { level = levelIt }).build()
        }
    }

    inline fun <A : HttpRequest?> doExecuteSimple(request: A): ResponseBody? {
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
        if (res.isSuccessful) {
            return res.body
        } else {
            throw WeiXinException("API_REQUEST_ERROR", res.code.toString())
        }
    }

    inline fun <reified R : BaseResponse?, A : HttpRequest?> doExecute(request: A): R {
        val body = doExecuteSimple(request)
        if (body?.contentType()?.subtype == "json") {
            return ObjectMapper().readValue(body.string(), R::class.java)
        } else {
            throw WeiXinException("CONTENT_TYPE_NOT_JSON")
        }
    }

    fun urlFormat(url: String): String {
        return "${BASE_URL}${if (url.startsWith("/")) url.substring(1) else url}"
    }

}