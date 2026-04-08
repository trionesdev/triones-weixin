package com.trionesdev.weixin.miniprogram.model

class CheckEncryptedDataRequest {
    var appId: String? = null
    var accessToken:String? = null
    var encryptedMsg: String? = null

    companion object {
        @JvmStatic
        fun builder(): Builder  {
            return Builder()
        }
    }

    class Builder {
        var request = CheckEncryptedDataRequest()
        fun appId(appId: String?) = apply { request.appId = appId }
        fun accessToken(accessToken: String?) = apply { request.accessToken = accessToken }
        fun encryptedMsg(encryptedMsg: String?) = apply { request.encryptedMsg = encryptedMsg }
        fun build() = request
    }
}