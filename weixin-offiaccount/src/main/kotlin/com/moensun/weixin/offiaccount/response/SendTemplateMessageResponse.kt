package com.moensun.weixin.offiaccount.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class SendTemplateMessageResponse : BaseResponse() {
    @JsonProperty(value = "msgid")
    var msgId: String? = null
}