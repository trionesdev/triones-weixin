package com.trionesdev.weixin.offiaccount

import com.trionesdev.weixin.base.WeiXin
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.sns.WeiXinSns
import com.trionesdev.weixin.offiaccount.jsapi.WeiXinOfficeAccountJsapi
import com.trionesdev.weixin.offiaccount.model.*
import okhttp3.OkHttpClient

class WeiXinOfficeAccount : WeiXin, WeiXinOfficeAccountTemplate {
    private var weiXinSns: WeiXinSns

    private var weiXinJsapi: WeiXinOfficeAccountJsapi

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient) {
        weiXinSns = WeiXinSns(weiXinConfig, wxHttpClient.httpClient)
        weiXinJsapi = WeiXinOfficeAccountJsapi(weiXinConfig, wxHttpClient.httpClient)
    }

    override fun getSnsInstance():WeiXinSns{
        return this.weiXinSns
    }

    override fun getJsapiInstance(): WeiXinOfficeAccountJsapi {
        return this.weiXinJsapi
    }

    // ----------------------------基础消息能力----------------------------
    //region 发送模板消息
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#发送模板消息
     */
    override fun sendTemplateMessage(request: SendTemplateMessageRequest): SendTemplateMessageResponse {
        val httpRequest = HttpRequest.Builder().post()
            .url("cgi-bin/message/template/send?access_token=${accessToken(request.accessToken)}")
            .jsonBody(request)
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    // ----------------------------基础消息能力----------------------------


    //-----------------------------用户管理----------------------------
    //region 用户管理/获取用户列表
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/User_Management/Getting_a_User_List.html
     */
    override fun getUserList(req: GetUserListRequest): GetUserListResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/get?access_token=${accessToken(req.accessToken)}&next_openid=${req.nextOpenId ?: ""}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion

    //region 用户管理/获取用户基本信息(UnionID机制)
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId
     */
    override fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/info?access_token=${accessToken(accessToken(req.accessToken))}&openid=${req.openId}&lang=${req.lang}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    //-----------------------------用户管理----------------------------


}