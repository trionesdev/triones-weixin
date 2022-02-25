package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.BaseResponse

class AccessTokenResponse : BaseResponse() {
    @JSONField(name = "access_token")
    var accessToken: String? = null

    @JSONField(name = "expires_in")
    var expiresIn: Int? = null
}