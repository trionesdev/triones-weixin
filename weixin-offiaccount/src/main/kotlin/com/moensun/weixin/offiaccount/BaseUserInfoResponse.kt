package com.moensun.weixin.offiaccount

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.http.BaseResponse

class BaseUserInfoResponse : BaseResponse() {
    var subscribe: String? = null

    @JSONField(name = "openid")
    var openId: String? = null
    var language: String? = null

    @JSONField(name = "subscribe_time")
    var subscribeTime: Long? = null

    @JSONField(name = "unionid")
    var unionId: String? = null
    var remark: String? = null

    @JSONField(name = "groupid")
    var groupId: Long? = null

    @JSONField(name = "tagid_list")
    var tagIdList: MutableList<Long>? = null

    @JSONField(name = "subscribe_scene")
    var subscribeScene: String? = null

    @JSONField(name = "qr_scene")
    var qrScene: Long? = null

    @JSONField(name = "qr_scene_str")
    var qrSceneStr: String? = null
}