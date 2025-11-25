package com.trionesdev.weixin.app

import com.trionesdev.weixin.base.WeXinTemplate
import com.trionesdev.weixin.base.sns.WeiXinSns

interface WeiXinAppTemplate : WeXinTemplate {

    fun getSnsInstance(): WeiXinSns
}