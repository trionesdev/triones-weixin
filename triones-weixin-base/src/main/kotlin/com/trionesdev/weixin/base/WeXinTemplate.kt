package com.trionesdev.weixin.base

import com.trionesdev.weixin.base.model.AccessTokenResponse

interface WeXinTemplate {
    fun appId(): String?

    fun getCredentials(key: String): WeiXinCredentials?

    fun getAccessToken(appId: String?): AccessTokenResponse
}