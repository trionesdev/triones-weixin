package com.trionesdev.weixin.base.sns

class SnsAccessTokenRequest {
    var code: String? = null

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val request: SnsAccessTokenRequest = SnsAccessTokenRequest()

        fun code(code: String?): Builder {
            request.code = code
            return this
        }

        fun build() = request
    }
}