package com.trionesdev.weixin.base

import okhttp3.logging.HttpLoggingInterceptor

open class WeiXinConfig : WeiXinCredentials() {
    var httpLogLevel: HttpLoggingInterceptor.Level? = null
    var cache: WeiXinCache? = null
    var multi: Boolean? = false

    /**
     * 多个微信平台账号时
     */
    var credentials: Map<String, WeiXinCredentials>? = null
}