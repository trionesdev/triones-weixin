package com.trionesdev.weixin.base.sns

class SnsAccessTokenValidRequest {
    var accessToken: String? = null
    var openId: String? = null

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val request: SnsAccessTokenValidRequest = SnsAccessTokenValidRequest()

        fun accessToken(accessToken: String?): Builder {
            request.accessToken = accessToken
            return this
        }

        fun openId(openId: String?): Builder {
            request.openId = openId
            return this
        }

        fun build() = request
    }
}