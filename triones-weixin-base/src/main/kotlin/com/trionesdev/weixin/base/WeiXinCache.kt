package com.trionesdev.weixin.base

interface WeiXinCache {


    /**
     * 普通access_token
     */
    fun getAccessToken(appId: String?): String?

    fun setAccessToken(appId: String?, token: String)

    /**
     * 网页授权access_token
     */
    fun getSnsAccessToken(appId: String?): String?

    fun setSnsAccessToken(appId: String?, token: String)
}