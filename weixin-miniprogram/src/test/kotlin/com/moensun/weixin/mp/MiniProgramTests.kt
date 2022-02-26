package com.moensun.weixin.mp

import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.miniprogram.MiniProgram
import org.junit.jupiter.api.Test

class MiniProgramTests {


    @Test
    fun accessTokenTest() {
        val client = miniProgramClient();
        val res = client.getAccessToken()
        print(res)
    }


    private fun miniProgramClient(): MiniProgram {
        val weiXinConfig = WeiXinConfig()
        weiXinConfig.appId = "wx08b199625847bec1";
        weiXinConfig.secret = "07d553878c1e8acdf349dade6923d428"
        return MiniProgram(weiXinConfig)
    }
}