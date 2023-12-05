package com.trionesdev.weixin.offiaccount

import com.trionesdev.weixin.commons.WeXinTemplate
import com.trionesdev.weixin.offiaccount.model.*

interface WeiXinOfficeAccountTemplate: WeXinTemplate {
    fun sendTemplateMessage(request: SendTemplateMessageRequest): SendTemplateMessageResponse

    fun getUserList(req: GetUserListRequest): GetUserListResponse

    fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse

}