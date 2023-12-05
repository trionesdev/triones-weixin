package com.trionesdev.weixin.miniprogram.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.commons.model.BaseResponse

class Code2SessionResponse : BaseResponse() {
    @JsonProperty(value = "openid")
    var openId: String? = null

    @JsonProperty(value = "session_key")
    var sessionKey: String? = null

    @JsonProperty(value = "unionid")
    var unionId: String? = null
}