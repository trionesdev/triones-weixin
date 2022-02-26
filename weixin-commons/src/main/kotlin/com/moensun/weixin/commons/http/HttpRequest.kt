package com.moensun.weixin.commons.http

import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class HttpRequest(
    var url: String?,
    var method: HttpMethod,
    var headers: Headers,
    var body: RequestBody?
) {

    open class Builder {
        internal var url: String? = null
        internal var method: HttpMethod
        internal var headers: Headers.Builder
        internal var body: RequestBody? = null

        constructor() {
            this.method = HttpMethod.GET
            this.headers = Headers.Builder()
        }

        open fun get(): Builder = apply {
            this.method = HttpMethod.GET
        }

        open fun post(): Builder = apply {
            this.method = HttpMethod.POST
        }

        open fun put(): Builder = apply {
            this.method = HttpMethod.PUT
        }

        open fun delete(): Builder = apply {
            this.method = HttpMethod.DELETE
        }

        open fun url(url: String?): Builder = apply {
            this.url = url
        }

        open fun headers(headers: Headers): Builder = apply {
            this.headers = headers.newBuilder()
        }

        open fun addHeader(name: String, value: String) = apply {
            headers.add(name, value)
        }

        open fun body(body: RequestBody?): Builder = apply {
            this.body = body
        }

        open fun jsonBody(body:String): Builder = apply {
            this.body = body.toRequestBody("application/json;charset=UTF-8".toMediaTypeOrNull())
        }

        open fun build(): HttpRequest {
            return HttpRequest(
                url,
                method,
                headers.build(),
                body
            )
        }
    }


}