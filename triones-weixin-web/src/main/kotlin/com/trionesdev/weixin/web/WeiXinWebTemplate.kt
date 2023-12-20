package com.trionesdev.weixin.web

import com.trionesdev.weixin.base.WeXinTemplate
import com.trionesdev.weixin.base.sns.WeiXinSns

interface WeiXinWebTemplate : WeXinTemplate {

    fun getSnsInstance(): WeiXinSns
}