package com.trionesdev.weixin.miniprogram.model

class GetUserPhoneNumberRequest {
    var appId: String? = null
    var accessToken: String? = null
    var code: String? = null
    var openId: String? = null

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {
        var request = GetUserPhoneNumberRequest()
        fun appId(appId: String?) = apply { request.appId = appId }
        fun accessToken(accessToken: String?) = apply { request.accessToken = accessToken }
        fun code(code: String?) = apply { request.code = code }
        fun openId(openId: String?) = apply { request.openId = openId }
        fun build() = request
    }
}