package com.trionesdev.weixin.base

import okhttp3.logging.HttpLoggingInterceptor

open class WeiXinConfig {
    var httpLogLevel: HttpLoggingInterceptor.Level? = null
    var appId: String? = null
    var secret: String? = null
    var weiXinCache: WeiXinCache? = null
}