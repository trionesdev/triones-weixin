package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonProperty

class SendTemplateMessageRequest : BaseRequest() {
    @JsonProperty(value = "touser")
    var toUser: String? = null

    @JsonProperty(value = "template_id")
    var templateId: String? = null
    val url: String? = null

    @JsonProperty(value = "miniprogram")
    var miniProgram: MiniProgram? = null
    var data: Map<String, ParamValue>? = null

    data class MiniProgram(
        @JsonProperty(value = "appid")
        var appId: String? = null,
        @JsonProperty(value = "pagepath")
        var pagePath: String? = null
    )

    data class ParamValue(
        var value: String? = null,
        var color: String? = null
    )
}