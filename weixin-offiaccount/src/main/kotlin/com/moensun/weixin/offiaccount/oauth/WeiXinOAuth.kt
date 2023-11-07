package com.moensun.weixin.offiaccount.oauth

import com.moensun.weixin.commons.WeiXin
import com.moensun.weixin.commons.model.BaseResponse
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.HttpRequest
import okhttp3.OkHttpClient

/**
 * 微信网页授权
 */
open class WeiXinOAuth : WeiXin {
    constructor(weiXinConfig: WeiXinConfig) : super(weiXinConfig)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)


    //region 微信网页开发
    /**
     * 通过code换取网页授权access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#1
     */
    fun getOauthAccessToken(request: OAuthAccessTokenRequest): OAuthAccessTokenResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/oauth2/access_token?appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}&code=${request.code}&grant_type=authorization_code")
            .build()
        val result: OAuthAccessTokenResponse = doExecute(httpRequest)
        weiXinConfig.weiXinCache?.setOAuthAccessToken(weiXinConfig.appId, result.accessToken!!)
        return result
    }

    /**
     * 刷新access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#2
     */
    fun refreshOauthAccessToken(request: OAuthRefreshTokenRequest): OAuthAccessTokenResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/oauth2/refresh_token?appid=${weiXinConfig.appId}&grant_type=refresh_token&refresh_token=${request.refreshToken}")
            .build()
        return doExecute(httpRequest)
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#3
     */
    fun getOauthUserInfo(request: OAuthUserInfoRequest): OAuthUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/userinfo?access_token=${oauthAccessToken(request.accessToken)}&openid=${request.openId}&lang=${request.lang}")
            .build()
        return doExecute(httpRequest)
    }

    /**
     * 检验授权凭证（access_token）是否有效
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#4
     */
    fun validOauthAccessToken(request: OAuthAccessTokenValidRequest): BaseResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/auth?access_token=${oauthAccessToken(request.accessToken)}&openid=${request.openId}")
            .build()
        return doExecute(httpRequest)
    }

    //endregion


    private fun oauthAccessToken(accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinConfig.weiXinCache?.let {
                return it.getOAuthAccessToken(weiXinConfig.appId)
            }
        }
    }

}