package com.trionesdev.weixin.commons

import com.trionesdev.weixin.commons.model.AccessTokenResponse

interface WeXinTemplate {
    fun appId(): String?

    fun getAccessToken(): AccessTokenResponse
}