package com.trionesdev.weixin.oplatform.web

import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.sns.WeiXinSns
import okhttp3.OkHttpClient

class WeXinWeb :WeiXinSns{
    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)
}