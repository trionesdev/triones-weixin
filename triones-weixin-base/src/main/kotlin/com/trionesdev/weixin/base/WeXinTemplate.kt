package com.trionesdev.weixin.base

import com.trionesdev.weixin.base.model.AccessTokenResponse

interface WeXinTemplate {
    fun appId(): String?

    fun getAccessToken(): AccessTokenResponse
}