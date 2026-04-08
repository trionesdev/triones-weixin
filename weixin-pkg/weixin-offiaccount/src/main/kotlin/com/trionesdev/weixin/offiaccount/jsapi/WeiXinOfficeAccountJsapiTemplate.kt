package com.trionesdev.weixin.offiaccount.jsapi

import com.trionesdev.weixin.base.sns.WeiXinSnsTemplate
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiSignatureRequest
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiTicketRequest
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiTicketResponse

interface WeiXinOfficeAccountJsapiTemplate: WeiXinSnsTemplate {

    fun getJsapiTicket(request: JsapiTicketRequest): JsapiTicketResponse

    fun jsapiSignature(request: JsapiSignatureRequest): String?
}