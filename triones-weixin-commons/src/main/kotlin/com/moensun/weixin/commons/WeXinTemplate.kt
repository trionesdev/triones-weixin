package com.moensun.weixin.commons

import com.moensun.weixin.commons.model.AccessTokenResponse

interface WeXinTemplate {
    fun appId(): String?

    fun getAccessToken(): AccessTokenResponse
}