package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.commons.model.BaseResponse

class WebAccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null

    @JsonProperty(value = "refresh_token")
    var refreshToken: String? = null

    @JsonProperty(value = "openid")
    var openId: String? = null
    var scope: String? = null
}