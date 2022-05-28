package com.moensun.weixin.offiaccount.message

import com.moensun.weixin.commons.http.BaseResponse
import com.moensun.weixin.commons.http.HttpRequest
import okhttp3.OkHttpClient

class OfficeAccountMessage {
    private var httpClient : OkHttpClient
    constructor(httpClient: OkHttpClient){
        this.httpClient = httpClient
    }
    //region 发送模板消息
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#发送模板消息
     */
    fun sendTemplateMessage(request: SendTemplateMessageRequest): BaseResponse {
        val httpRequest = HttpRequest.Builder().post()
            .url("cgi-bin/message/template/send?access_token=${request.accessToken}")
            .jsonBody(request)
            .build()
        return httpClient.doExecute(httpRequest)
    }
    //endregion
}