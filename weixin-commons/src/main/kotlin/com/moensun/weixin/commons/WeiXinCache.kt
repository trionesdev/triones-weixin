package com.moensun.weixin.commons

interface WeiXinCache {
    /**
     * 网页授权access_token
     */
    fun getOAuthAccessToken(): String

    /**
     * 普通access_token
     */
    fun getAccessToken(): String

    fun setOAuthAccessToken(token: String)

    fun setAccessToken(token: String)
}