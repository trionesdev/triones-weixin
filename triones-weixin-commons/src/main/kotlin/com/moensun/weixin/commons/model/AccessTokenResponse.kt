package com.moensun.weixin.commons.model

import com.fasterxml.jackson.annotation.JsonProperty


class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}