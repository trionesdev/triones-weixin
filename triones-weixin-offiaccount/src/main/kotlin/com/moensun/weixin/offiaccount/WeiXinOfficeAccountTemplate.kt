package com.moensun.weixin.offiaccount

import com.moensun.weixin.commons.WeXinTemplate
import com.moensun.weixin.offiaccount.model.*

interface WeiXinOfficeAccountTemplate: WeXinTemplate {
    fun sendTemplateMessage(request: SendTemplateMessageRequest): SendTemplateMessageResponse

    fun getUserList(req: GetUserListRequest): GetUserListResponse

    fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse

}