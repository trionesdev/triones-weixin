package com.moensun.weixin.offiaccount.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}