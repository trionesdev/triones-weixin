package com.trionesdev.weixin.miniprogram.model

class CreateQRCodeRequest {
    var appId: String? = null
    var accessToken: String? = null
    var path: String? = null
    var width: Int? = null

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {
        var request = CreateQRCodeRequest()
        fun appId(appId: String?) = apply { request.appId = appId }
        fun accessToken(accessToken: String?) = apply { request.accessToken = accessToken }
        fun path(path: String?) = apply { request.path = path }
        fun width(width: Int?) = apply { request.width = width }
        fun build() = request
    }
}