package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.http.BaseResponse

class Code2SessionResponse : BaseResponse() {
    @JSONField(name = "openid")
    var openId: String? = null

    @JSONField(name = "session_key")
    var sessionKey: String? = null

    @JSONField(name = "unionid")
    var unionId: String? = null
}