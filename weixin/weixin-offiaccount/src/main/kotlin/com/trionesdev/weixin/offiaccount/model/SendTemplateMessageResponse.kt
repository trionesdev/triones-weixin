package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class SendTemplateMessageResponse : BaseResponse() {
    @JsonProperty(value = "msgid")
    var msgId: String? = null
}