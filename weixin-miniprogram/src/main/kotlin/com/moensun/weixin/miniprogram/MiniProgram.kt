package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.JSON
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.HttpRequest
import com.moensun.weixin.commons.http.WeiXinHttpClient
import okhttp3.OkHttpClient
import org.apache.commons.codec.digest.DigestUtils

class MiniProgram : WeiXinHttpClient {

    constructor(weiXinConfig: WeiXinConfig) : super(weiXinConfig)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient) : super(weiXinConfig, httpClient)

    //region 登录
    /**
     * 登录凭证校验
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     */
    fun code2Session(code: String): Code2SessionResponse {
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
    fun checkEncryptedData(checkEncryptedDataRequest: CheckEncryptedDataRequest): CheckEncryptedDataResponse {
        val body = mutableMapOf<String, String>()
        body["encrypted_msg_hash"] = DigestUtils.sha1Hex(checkEncryptedDataRequest.encryptedMsg)
        val request = HttpRequest.Builder().post()
            .url("wxa/business/checkencryptedmsg?access_token=${accessToken(checkEncryptedDataRequest.accessToken)}")
            .jsonBody(JSON.toJSONString(body))
            .build()
        return doExecute(request)
    }
    //endregion

}