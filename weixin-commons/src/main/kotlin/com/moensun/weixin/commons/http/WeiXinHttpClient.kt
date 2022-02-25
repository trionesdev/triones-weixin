package com.moensun.weixin.commons.http

import com.moensun.weixin.commons.WeiXinConfig

open class WeiXinHttpClient {
    companion object {
        const val BASE_URL: String = "https://api.weixin.qq.com"
    }

    var weiXinConfig: WeiXinConfig

    constructor(weiXinConfig: WeiXinConfig) {
        this.weiXinConfig = weiXinConfig;
    }

    fun doExecute() {

    }

}