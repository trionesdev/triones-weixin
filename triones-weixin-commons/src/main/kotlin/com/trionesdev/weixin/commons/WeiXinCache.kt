package com.trionesdev.weixin.commons

interface WeiXinCache {
    /**
     * 网页授权access_token
     */
    fun getOAuthAccessToken(appId: String?): String?

    /**
     * 普通access_token
     */
    fun getAccessToken(appId: String?): String?

    fun setOAuthAccessToken(appId: String?, token: String)

    fun setAccessToken(appId: String?, token: String)
}