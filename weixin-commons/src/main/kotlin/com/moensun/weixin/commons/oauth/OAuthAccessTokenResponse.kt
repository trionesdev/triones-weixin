package com.moensun.weixin.commons.oauth

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.http.BaseResponse

class OAuthAccessTokenResponse : BaseResponse() {
    @JSONField(name = "access_token")
    var accessToken: String? = null

    @JSONField(name = "expires_in")
    var expiresIn: Long? = null

    @JSONField(name = "refresh_token")
    var refreshToken: String? = null

    @JSONField(name = "openid")
    var openId: String? = null
    var scope: String? = null
}