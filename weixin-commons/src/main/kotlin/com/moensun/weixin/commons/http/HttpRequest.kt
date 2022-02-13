package com.moensun.weixin.commons.http

class HttpRequest {
    var url: String? = null
    var method: String? = null
    var headers: MutableMap<String, String>? = null
    var mediaType: String? = null
    var body: String? = null
}