package com.moensun.weixin.commons.http

import com.alibaba.fastjson.annotation.JSONField

class AccessTokenResponse : BaseResponse() {
    @JSONField(name = "access_token")
    var accessToken: String? = null

    @JSONField(name = "expires_in")
    var expiresIn: Int? = null
}