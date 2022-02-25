package com.moensun.weixin.mp

import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.miniprogram.AccessTokenRequest
import com.moensun.weixin.miniprogram.MiniProgramClient
import org.junit.jupiter.api.Test

class MiniProgramClientTests {


    @Test
    fun accessTokenTest() {
        val client = miniProgramClient();
        val req = AccessTokenRequest()
     val res =   client.getAccessToken(req)
        print(res)
    }


    private fun miniProgramClient(): MiniProgramClient {
        val weiXinConfig = WeiXinConfig()
        weiXinConfig.appId = "wx08b199625847bec1";
        weiXinConfig.secret = "07d553878c1e8acdf349dade6923d428"
        return MiniProgramClient(weiXinConfig)
    }
}