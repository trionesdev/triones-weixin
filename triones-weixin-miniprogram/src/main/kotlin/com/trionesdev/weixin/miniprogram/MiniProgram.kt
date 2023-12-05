package com.trionesdev.weixin.miniprogram

import com.fasterxml.jackson.databind.ObjectMapper
import com.trionesdev.weixin.commons.WeiXin
import com.trionesdev.weixin.commons.WeiXinConfig
import com.trionesdev.weixin.commons.http.HttpRequest
import com.trionesdev.weixin.miniprogram.model.CheckEncryptedDataRequest
import com.trionesdev.weixin.miniprogram.model.GetUserPhoneNumberRequest
import com.trionesdev.weixin.miniprogram.model.CheckEncryptedDataResponse
import com.trionesdev.weixin.miniprogram.model.Code2SessionResponse
import com.trionesdev.weixin.miniprogram.model.UserPhoneNumberResponse
import okhttp3.OkHttpClient
import org.apache.commons.codec.digest.DigestUtils

class MiniProgram : WeiXin, WeiXinMiniProgramTemplate {

    constructor(weiXinConfig: WeiXinConfig) : super(weiXinConfig)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient) : super(weiXinConfig, httpClient)

    //region 登录
    /**
     * 登录凭证校验
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     */
    override fun code2Session(code: String): Code2SessionResponse {
        val request = HttpRequest.Builder().get()
            .url("sns/jscode2session?appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}&js_code=${code}&grant_type=authorization_code")
            .build()
        return doExecute(request)
    }
    //endregion

    //region 用户信息
    /**
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/user-info/auth.checkEncryptedData.html
     */
    override fun checkEncryptedData(checkEncryptedDataRequest: CheckEncryptedDataRequest): CheckEncryptedDataResponse {
        val body = mutableMapOf<String, String>()
        body["encrypted_msg_hash"] = DigestUtils.sha1Hex(checkEncryptedDataRequest.encryptedMsg)
        val request = HttpRequest.Builder().post()
            .url("wxa/business/checkencryptedmsg?access_token=${accessToken(checkEncryptedDataRequest.accessToken)}")
            .jsonBody(ObjectMapper().writeValueAsString(body))
            .build()
        return doExecute(request)
    }
    //endregion


    //region 获取手机号
    /**
     * https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-info/phone-number/getPhoneNumber.html#%E8%B0%83%E7%94%A8%E6%96%B9%E5%BC%8F
     */
    override fun getUserPhoneNumber(getUserPhoneNumberRequest: GetUserPhoneNumberRequest): UserPhoneNumberResponse {
        val body = mutableMapOf<String, String?>()
        body["code"] = getUserPhoneNumberRequest.code
        val request = HttpRequest.Builder().post()
            .url("wxa/business/getuserphonenumber?access_token=${accessToken(getUserPhoneNumberRequest.accessToken)}")
            .jsonBody(ObjectMapper().writeValueAsString(body))
            .build()
        return doExecute(request)
    }
    //endregion

}