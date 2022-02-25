package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.JSON
import com.google.common.hash.Hashing
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.HttpRequest
import com.moensun.weixin.commons.http.WeiXinHttpClient
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.nio.charset.Charset

class MiniProgramClient(weiXinConfig: WeiXinConfig) : WeiXinHttpClient(weiXinConfig) {

    fun code2Session(code: String): Code2SessionResponse {
        val request = HttpRequest.Builder().get()
            .url("sns/jscode2session?appid=${weiXinConfig.appId}&secret=${weiXinConfig.secret}&js_code=${code}&grant_type=authorization_code")
            .build()
        return doExecute(request)
    }

    fun getAccessToken(): AccessTokenResponse {
        val request = HttpRequest.Builder().get()
            .url("cgi-bin/token?grant_type=client_credential&appid=${this.weiXinConfig.appId}&secret=${this.weiXinConfig.secret}")
            .build()
        return doExecute(request)
    }

    fun checkEncryptedData(accessToken: String): CheckEncryptedDataResponse {
        var body = mutableMapOf<String, String>()
        body["encrypted_msg_hash"] = Hashing.sha256().newHasher().putString("", Charset.defaultCharset()).toString()
        val request = HttpRequest.Builder().post()
            .url("wxa/business/checkencryptedmsg?access_token=${accessToken}")
            .jsonBody(JSON.toJSONString(body))
            .build()
        return doExecute(request)
    }

}