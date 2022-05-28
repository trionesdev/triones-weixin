package com.moensun.weixin.miniprogram

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.http.BaseResponse

class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}