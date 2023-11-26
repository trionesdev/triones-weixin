package com.moensun.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.model.BaseResponse

class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}