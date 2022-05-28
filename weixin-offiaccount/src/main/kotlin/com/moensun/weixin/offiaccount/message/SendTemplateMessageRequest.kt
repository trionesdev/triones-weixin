package com.moensun.weixin.offiaccount.message

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.offiaccount.BaseRequest

class SendTemplateMessageRequest : BaseRequest() {
    @JsonProperty(value = "touser")
    var toUser: String? = null

    @JsonProperty(value = "template_id")
    var templateId: String? = null
    val url: String? = null

    @JsonProperty(value = "miniprogram")
    val miniProgram: MiniProgram? = null
    var data: Map<String, ParamValue>? = null

    data class MiniProgram(
        @JsonProperty(value = "appid")
        val appId: String? = null,
        @JsonProperty(value = "pagepath")
        val pagePath: String? = null
    )

    data class ParamValue(
        val value: String? = null,
        val color: String? = null
    )
}