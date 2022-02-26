package com.moensun.weixin.commons

interface WeiXinCache {
    fun oauthAccessToken(): String
    fun accessToken(): String
}