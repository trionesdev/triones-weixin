package com.trionesdev.weixin.base.sns

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class SnsAccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Long? = null

    @JsonProperty(value = "refresh_token")
    var refreshToken: String? = null

    @JsonProperty(value = "openid")
    var openId: String? = null
    var scope: String? = null

    @JsonProperty(value = "unionid")
    var unionId: String? = null
}