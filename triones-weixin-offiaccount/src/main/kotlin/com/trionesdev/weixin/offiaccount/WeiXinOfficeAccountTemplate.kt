package com.trionesdev.weixin.offiaccount

import com.trionesdev.weixin.base.WeXinTemplate
import com.trionesdev.weixin.base.sns.WeiXinSns
import com.trionesdev.weixin.base.sns.WeiXinSnsTemplate
import com.trionesdev.weixin.offiaccount.jsapi.WeiXinOfficeAccountJsapi
import com.trionesdev.weixin.offiaccount.model.*

interface WeiXinOfficeAccountTemplate : WeXinTemplate {
    fun getSnsInstance(): WeiXinSns

    fun getJsapiInstance(): WeiXinOfficeAccountJsapi

    fun sendTemplateMessage(request: SendTemplateMessageRequest): SendTemplateMessageResponse

    fun getUserList(req: GetUserListRequest): GetUserListResponse

    fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse

}