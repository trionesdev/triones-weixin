package com.moensun.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class SendTemplateMessageResponse : BaseResponse() {
    @JsonProperty(value = "msgid")
    var msgId: String? = null
}