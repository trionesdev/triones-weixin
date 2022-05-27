package com.moensun.weixin.offiaccount

import com.fasterxml.jackson.annotation.JsonProperty

data class SendTemplateMessageRequest(
    @JsonProperty(value = "touser")
    val toUser: String? = null,
    @JsonProperty(value = "template_id")
    val templateId: String? = null,
    val url: String? = null,

    @JsonProperty(value = "miniprogram")
    val miniProgram: MiniProgram? = null,
    val data: Map<String, ParamValue>? = null
) : BaseRequest(){


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