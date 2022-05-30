package com.moensun.weixin.offiaccount.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class GetBaseUserInfoResponse : BaseResponse() {
    var subscribe: String? = null

    @JsonProperty(value = "openid")
    var openId: String? = null
    var nickname: String? = null
    var sex:Int? = null
    var language: String? = null
    var city:String? = null
    var province:String? = null
    var country:String? = null
    @JsonProperty(value = "headimgurl")
    var headImgUrl:String? = null

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