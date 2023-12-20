package com.trionesdev.weixin.base.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 接口调用凭证
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AccessTokenResponse : BaseResponse() {
    @JsonProperty(value = "access_token")
    var accessToken: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}