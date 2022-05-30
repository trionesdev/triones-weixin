package com.moensun.weixin.miniprogram.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

class Code2SessionResponse : BaseResponse() {
    @JsonProperty(value = "openid")
    var openId: String? = null

    @JsonProperty(value = "session_key")
    var sessionKey: String? = null

    @JsonProperty(value = "unionid")
    var unionId: String? = null
}