package com.moensun.weixin.offiaccount.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.http.BaseResponse

class BaseUserInfoResponse : BaseResponse() {
    var subscribe: String? = null

    @JsonProperty(value = "openid")
    var openId: String? = null
    var language: String? = null

    @JsonProperty(value = "subscribe_time")
    var subscribeTime: Long? = null

    @JsonProperty(value = "unionid")
    var unionId: String? = null
    var remark: String? = null

    @JsonProperty(value = "groupid")
    var groupId: Long? = null

    @JsonProperty(value = "tagid_list")
    var tagIdList: MutableList<Long>? = null

    @JsonProperty(value = "subscribe_scene")
    var subscribeScene: String? = null

    @JsonProperty(value = "qr_scene")
    var qrScene: Long? = null

    @JsonProperty(value = "qr_scene_str")
    var qrSceneStr: String? = null
}