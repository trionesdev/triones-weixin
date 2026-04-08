package com.trionesdev.weixin.app

import com.trionesdev.weixin.base.WeiXin
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.sns.WeiXinSns
import okhttp3.OkHttpClient

class WeiXinApp : WeiXin, WeiXinAppTemplate {
    private var weiXinSns: WeiXinSns

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient) {
        weiXinSns = WeiXinSns(weiXinConfig, wxHttpClient.httpClient)
    }

    override fun getSnsInstance(): WeiXinSns {
        return this.weiXinSns
    }
}