package com.moensun.weixin.commons.oauth

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.http.BaseResponse

class OAuthUserInfoResponse : BaseResponse() {
    @JSONField(name = "openid")
    val openId: String? = null
    val nickname: String? = null
    val sex: Int? = null
    val province: String? = null
    val city: String? = null
    val country: String? = null

    @JSONField(name = "headimgurl")
    val headImgUrl: String? = null
    val privilege: MutableList<String>? = null

    @JSONField(name = "unionid")
    val unionId: String? = null
}