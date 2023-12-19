package com.trionesdev.weixin.offiaccount

import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.sns.WeiXinSns
import com.trionesdev.weixin.offiaccount.model.GetBaseUserInfoRequest
import com.trionesdev.weixin.offiaccount.model.GetUserListRequest
import com.trionesdev.weixin.offiaccount.model.SendTemplateMessageRequest
import com.trionesdev.weixin.offiaccount.model.GetBaseUserInfoResponse
import com.trionesdev.weixin.offiaccount.model.GetUserListResponse
import com.trionesdev.weixin.offiaccount.model.SendTemplateMessageResponse
import okhttp3.OkHttpClient

class WeiXinOfficeAccount : WeiXinSns, WeiXinOfficeAccountTemplate {

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)


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