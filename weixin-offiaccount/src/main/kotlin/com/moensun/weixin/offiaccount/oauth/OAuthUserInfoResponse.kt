package com.moensun.weixin.offiaccount.oauth

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.model.BaseResponse

class OAuthUserInfoResponse : BaseResponse() {
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