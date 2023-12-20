package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}