package com.trionesdev.weixin.oplatform

import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.sns.WeiXinSns
import com.trionesdev.weixin.oplatform.app.WeiXinApp
import com.trionesdev.weixin.oplatform.web.WeXinWeb
import okhttp3.OkHttpClient

class WeiXinOpenPlatform {
    fun getAppInstance(): WeiXinApp?{
        return null
    }

    fun getWebInstance():WeXinWeb?{
        return null
    }
}