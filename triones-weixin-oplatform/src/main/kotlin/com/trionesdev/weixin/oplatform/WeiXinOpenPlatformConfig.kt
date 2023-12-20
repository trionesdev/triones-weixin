package com.trionesdev.weixin.oplatform

import com.trionesdev.weixin.base.WeiXinConfig

class WeiXinOpenPlatformConfig {
    var app: AppConfig? = null
    var web: WebConfig? = null

    class AppConfig : WeiXinConfig() {
        var enabled: Boolean? = null
    }

    class WebConfig : WeiXinConfig() {
        var enabled: Boolean? = null
    }
}