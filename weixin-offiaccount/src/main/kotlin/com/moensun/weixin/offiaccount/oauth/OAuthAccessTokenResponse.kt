package com.moensun.weixin.offiaccount.oauth

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

class OAuthAccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Long? = null

    @JsonProperty(value = "refresh_token")
    var refreshToken: String? = null

    @JsonProperty(value = "openid")
    var openId: String? = null
    var scope: String? = null
}