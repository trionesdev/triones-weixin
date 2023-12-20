package com.trionesdev.weixin.web

import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.sns.WeiXinSns
import okhttp3.OkHttpClient

class WeiXinWeb : WeiXinSns, WeiXinWebTemplate {
    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)
}