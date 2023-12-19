package com.trionesdev.weixin.base.sns

import com.trionesdev.weixin.base.WeXinTemplate
import com.trionesdev.weixin.base.model.BaseResponse

interface WeiXinSnsTemplate: WeXinTemplate {

    /**
     * 通过code换取网页授权access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#1
     */
    fun getSnsAccessToken(request: SnsAccessTokenRequest): SnsAccessTokenResponse
    /**
     * 刷新access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#2
     */
    fun refreshSnsAccessToken(request: SnsRefreshTokenRequest): SnsAccessTokenResponse

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#3
     */
    fun getSnsUserInfo(request: SnsUserInfoRequest): SnsUserInfoResponse
    /**
     * 检验授权凭证（access_token）是否有效
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#4
     */
    fun validSnsAccessToken(request: SnsAccessTokenValidRequest): BaseResponse
}