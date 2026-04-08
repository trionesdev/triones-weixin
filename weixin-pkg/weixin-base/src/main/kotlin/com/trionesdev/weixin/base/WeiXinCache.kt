package com.trionesdev.weixin.base

interface WeiXinCache {


    /**
     * 普通access_token
     */
    fun getAccessToken(appId: String?): String?

    fun setAccessToken(appId: String?, token: String?, expiresIn: Long?)

    /**
     * 网页授权access_token
     */
    fun getSnsAccessToken(appId: String?): String?

    fun setSnsAccessToken(appId: String?, token: String?, expiresIn: Long?)

    /**
     * 获取公众号用于调用微信JS接口的临时票据
     */
    fun getJsapiTicket(appId: String?): String?

    fun setJsapiTicket(appId: String?, ticket: String?)
}