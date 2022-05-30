package com.moensun.weixin.offiaccount

import com.moensun.weixin.commons.WeiXin
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.BaseResponse
import com.moensun.weixin.commons.http.HttpRequest
import com.moensun.weixin.offiaccount.request.GetBaseUserInfoRequest
import com.moensun.weixin.offiaccount.request.SendTemplateMessageRequest
import com.moensun.weixin.offiaccount.request.GetUserListRequest
import com.moensun.weixin.offiaccount.response.GetBaseUserInfoResponse
import com.moensun.weixin.offiaccount.response.GetUserListResponse
import com.moensun.weixin.offiaccount.response.WebAccessTokenResponse
import okhttp3.OkHttpClient

class OfficeAccount : WeiXin {

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)


    // ----------------------------基础消息能力----------------------------
    //region 发送模板消息
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#发送模板消息
     */
    fun sendTemplateMessage(request: SendTemplateMessageRequest): BaseResponse {
        val httpRequest = HttpRequest.Builder().post()
            .url("cgi-bin/message/template/send?access_token=${request.accessToken}")
            .jsonBody(request)
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    // ----------------------------基础消息能力----------------------------

    //-----------------------------微信网页开发----------------------------
    //region 通过 code 换取网页授权access_token
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html
     */
    fun getWebAccessToken(code: String): WebAccessTokenResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/oauth2/access_token?appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}&code=${code}&grant_type=authorization_code")
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    //-----------------------------微信网页开发----------------------------


    //-----------------------------用户管理----------------------------
    //region 用户管理/获取用户列表
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/User_Management/Getting_a_User_List.html
     */
    fun getUserList(req: GetUserListRequest): GetUserListResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/get?access_token=${req.accessToken}&next_openid=${req.nextOpenId ?: ""}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion

    //region 用户管理/获取用户基本信息(UnionID机制)
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId
     */
    fun getUserBasicInformation(getBaseUserInfoRequest: GetBaseUserInfoRequest): GetBaseUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/info?access_token=${accessToken(getBaseUserInfoRequest.accessToken)}&openid=${getBaseUserInfoRequest.openId}&lang=${getBaseUserInfoRequest.lang}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion
    //-----------------------------用户管理----------------------------


}