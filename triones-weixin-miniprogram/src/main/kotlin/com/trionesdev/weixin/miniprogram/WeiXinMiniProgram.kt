package com.trionesdev.weixin.miniprogram

import com.fasterxml.jackson.databind.ObjectMapper
import com.trionesdev.weixin.base.WeiXin
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.miniprogram.model.*
import okhttp3.OkHttpClient
import org.apache.commons.codec.digest.DigestUtils

class WeiXinMiniProgram : WeiXin, WeiXinMiniProgramTemplate {

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

    /**
     * 获取小程序码
     * https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getQRCode.html
     */
    override fun getQRCode(getQRCodeRequest: GetQRCodeRequest): ByteArray? {
        val body = mutableMapOf<String, Any?>()
        body["path"] = getQRCodeRequest.path
        getQRCodeRequest.width?.let { body["width"] = it }
        getQRCodeRequest.autoColor?.let { body["auto_color"] = it }
        getQRCodeRequest.lineColor?.let { body["line_color"] = it }
        getQRCodeRequest.hyaline?.let { body["is_hyaline"] = it }
        getQRCodeRequest.envVersion?.let { body["env_version"] = it }
        val request = HttpRequest.Builder().post()
            .url("wxa/getwxacode?access_token=${accessToken(getQRCodeRequest.accessToken)}")
            .jsonBody(ObjectMapper().writeValueAsString(body))
            .build()
        val res = doExecuteSimple(request)
        return res?.bytes()
    }

    /**
     * 获取小程序二维码
     * https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/createQRCode.html
     */
    override fun createQRCode(createQRCodeRequest: CreateQRCodeRequest): ByteArray? {
        val body = mutableMapOf<String, String?>()
        body["path"] = createQRCodeRequest.path
        createQRCodeRequest.width?.let { body["width"] = it.toString() }
        val request = HttpRequest.Builder().post()
            .url("cgi-bin/wxaapp/createwxaqrcode?access_token=${accessToken(createQRCodeRequest.accessToken)}")
            .jsonBody(ObjectMapper().writeValueAsString(body))
            .build()
        val res = doExecuteSimple(request)
        return res?.bytes()
    }

}