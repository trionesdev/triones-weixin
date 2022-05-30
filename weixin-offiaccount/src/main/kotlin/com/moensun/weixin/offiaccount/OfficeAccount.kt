package com.moensun.weixin.offiaccount

import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.res.BaseResponse
import com.moensun.weixin.commons.http.HttpRequest
import com.moensun.weixin.offiaccount.oauth.WeiXinOAuth
import com.moensun.weixin.offiaccount.request.GetBaseUserInfoRequest
import com.moensun.weixin.offiaccount.request.GetUserListRequest
import com.moensun.weixin.offiaccount.request.SendTemplateMessageRequest
import com.moensun.weixin.offiaccount.response.GetBaseUserInfoResponse
import com.moensun.weixin.offiaccount.response.GetUserListResponse
import okhttp3.OkHttpClient

class OfficeAccount : WeiXinOAuth {

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)


    // ----------------------------基础消息能力----------------------------
    //region 发送模板消息
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#发送模板消息
     */
    fun sendTemplateMessage(request: SendTemplateMessageRequest): BaseResponse {
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
    fun getUserList(req: GetUserListRequest): GetUserListResponse {
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
    fun getUserBasicInformation(req: GetBaseUserInfoRequest): GetBaseUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/info?access_token=${accessToken(accessToken(req.accessToken))}&openid=${req.openId}&lang=${req.lang}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    //-----------------------------用户管理----------------------------


}