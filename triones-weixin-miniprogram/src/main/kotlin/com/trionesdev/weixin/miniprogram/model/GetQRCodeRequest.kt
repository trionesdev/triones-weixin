package com.trionesdev.weixin.miniprogram.model

class GetQRCodeRequest {
    var appId: String? = null
    var accessToken: String? = null
    var path: String? = null
    var width: Int? = null
    var autoColor: Boolean? = null
    var lineColor: Rgb? = null
    var hyaline: Boolean? = null
    var envVersion: String? = null

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {
        var request = GetQRCodeRequest()
        fun appId(appId: String?) = apply { request.appId = appId }
        fun accessToken(accessToken: String?) = apply { request.accessToken = accessToken }
        fun path(path: String?) = apply { request.path = path }
        fun width(width: Int?) = apply { request.width = width }
        fun autoColor(autoColor: Boolean?) = apply { request.autoColor = autoColor }
        fun lineColor(lineColor: Rgb?) = apply { request.lineColor = lineColor }
        fun hyaline(hyaline: Boolean?) = apply { request.hyaline = hyaline }
        fun envVersion(envVersion: String?) = apply { request.envVersion = envVersion }
        fun build() = request
    }
}