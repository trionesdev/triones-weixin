package com.trionesdev.weixin.base.sns

import com.trionesdev.weixin.base.WeiXin
import com.trionesdev.weixin.base.model.BaseResponse
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.http.HttpRequest
import okhttp3.OkHttpClient

/**
 * 微信网页授权
 */
open class WeiXinSns : WeiXin, WeiXinSnsTemplate {
    constructor(weiXinConfig: WeiXinConfig) : super(weiXinConfig)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)


    //region 微信网页开发
    /**
     * 通过code换取网页授权access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#1
     */
    override fun getSnsAccessToken(request: SnsAccessTokenRequest): SnsAccessTokenResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/oauth2/access_token?appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}&code=${request.code}&grant_type=authorization_code")
            .build()
        val result: SnsAccessTokenResponse = doExecute(httpRequest)
        weiXinCache?.setSnsAccessToken(weiXinConfig.appId, result.accessToken, result.expiresIn)
        return result
    }

    /**
     * 刷新access_token
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#2
     */
    override fun refreshSnsAccessToken(request: SnsRefreshTokenRequest): SnsAccessTokenResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/oauth2/refresh_token?appid=${weiXinConfig.appId}&grant_type=refresh_token&refresh_token=${request.refreshToken}")
            .build()
        return doExecute(httpRequest)
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#3
     */
    override fun getSnsUserInfo(request: SnsUserInfoRequest): SnsUserInfoResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/userinfo?access_token=${snsAccessToken(request.accessToken)}&openid=${request.openId}&lang=${request.lang}")
            .build()
        return doExecute(httpRequest)
    }

    /**
     * 检验授权凭证（access_token）是否有效
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html#4
     */
    override fun validSnsAccessToken(request: SnsAccessTokenValidRequest): BaseResponse {
        val httpRequest = HttpRequest.Builder().get()
            .url("sns/auth?access_token=${snsAccessToken(request.accessToken)}&openid=${request.openId}")
            .build()
        return doExecute(httpRequest)
    }

    //endregion


    private fun snsAccessToken(accessToken: String?): String? {
        return accessToken?.let {
            return it
        } ?: let {
            return weiXinCache?.let { cacheIt ->
                return cacheIt.getSnsAccessToken(weiXinConfig.appId)
            }
        }
    }

}