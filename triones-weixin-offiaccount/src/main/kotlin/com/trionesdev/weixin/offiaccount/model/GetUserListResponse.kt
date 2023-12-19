package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class GetUserListResponse : BaseResponse() {
    var total: Long? = null
    var count: Long? = null
    var data: Data? = null
    @JsonProperty(value = "next_openid")
    var nextOpenId: String? = null

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Data(
        @JsonProperty(value = "openid")
        var openId: MutableList<String>?
    )
}