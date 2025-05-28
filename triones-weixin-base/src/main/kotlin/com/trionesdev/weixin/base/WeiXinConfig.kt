package com.trionesdev.weixin.base

import okhttp3.logging.HttpLoggingInterceptor

open class WeiXinConfig : WeiXinIdentity(){
    var httpLogLevel: HttpLoggingInterceptor.Level? = null
    var cache: WeiXinCache? = null
    var multi: List<WeiXinIdentity>? = null
}