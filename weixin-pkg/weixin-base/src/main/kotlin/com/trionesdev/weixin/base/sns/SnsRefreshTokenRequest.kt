package com.trionesdev.weixin.base.sns

class SnsRefreshTokenRequest {
    var refreshToken: String? = null

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val request: SnsRefreshTokenRequest = SnsRefreshTokenRequest()

        fun refreshToken(refreshToken: String?): Builder {
            request.refreshToken = refreshToken
            return this
        }

        fun build() = request
    }
}