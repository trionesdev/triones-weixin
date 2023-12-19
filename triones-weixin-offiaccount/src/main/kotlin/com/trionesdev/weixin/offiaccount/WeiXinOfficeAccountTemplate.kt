package com.trionesdev.weixin.offiaccount

import com.trionesdev.weixin.base.sns.WeiXinSnsTemplate
import com.trionesdev.weixin.offiaccount.model.*

interface WeiXinOfficeAccountTemplate: WeiXinSnsTemplate {


    fun sendTemplateMessage(request: SendTemplateMessageRequest): SendTemplateMessageResponse

    fun getUserList(req: GetUserListRequest): GetUserListResponse

    fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse

}