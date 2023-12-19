package com.trionesdev.weixin.base.sns

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

class SnsUserInfoResponse : BaseResponse() {
    @JsonProperty(value = "openid")
    val openId: String? = null
    val nickname: String? = null
    val sex: Int? = null
    val province: String? = null
    val city: String? = null
    val country: String? = null

    @JsonProperty(value = "headimgurl")
    val headImgUrl: String? = null
    val privilege: MutableList<String>? = null

    @JsonProperty(value = "unionid")
    val unionId: String? = null
}