package com.moensun.weixin.offiaccount

import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.HttpRequest
import com.moensun.weixin.commons.http.WeiXinHttpClient
import okhttp3.OkHttpClient

class OfficeAccount : WeiXinHttpClient {
    constructor(weiXinConfig: WeiXinConfig) : super(weiXinConfig)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient) : super(weiXinConfig, httpClient)


    //region 用户管理
    /**
     * https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId
     */
    fun getUserBasicInformation(baseUserInfoRequest: BaseUserInfoRequest): BaseUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("cgi-bin/user/info?access_token=${accessToken(baseUserInfoRequest.accessToken)}&openid=${baseUserInfoRequest.openId}&lang=${baseUserInfoRequest.lang}")
            .build()
        return doExecute(httpRequest)
    }
    //endregion



}