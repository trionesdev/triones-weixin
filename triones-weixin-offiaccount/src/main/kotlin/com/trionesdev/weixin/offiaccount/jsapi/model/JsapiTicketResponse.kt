package com.trionesdev.weixin.offiaccount.jsapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

class JsapiTicketResponse : BaseResponse() {
    var ticket: String? = null

    @JsonProperty(value = "expires_in")
    var expiresIn: Int? = null
}