package com.trionesdev.weixin.base.sns

class SnsUserInfoRequest {
    var accessToken: String? = null
    var openId: String? = null
    var lang: String = "zh_CN"

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val request: SnsUserInfoRequest = SnsUserInfoRequest()

        fun accessToken(accessToken: String?): Builder {
            request.accessToken = accessToken
            return this
        }

        fun openId(openId: String?): Builder {
            request.openId = openId
            return this
        }

        fun lang(lang: String): Builder {
            request.lang = lang
            return this
        }

        fun build() = request
    }
}