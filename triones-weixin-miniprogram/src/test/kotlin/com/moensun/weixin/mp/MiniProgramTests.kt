package com.moensun.weixin.mp

import com.alibaba.fastjson2.JSON
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.miniprogram.MiniProgram
import org.junit.jupiter.api.Test

class MiniProgramTests {


    @Test
    fun accessTokenTest() {
        val client = miniProgramClient();
        val res = client.getAccessToken()
        print(JSON.toJSONString(res))
    }

    @Test
    fun code2SessionTest() {
        val client = miniProgramClient();
        val res = client.code2Session("0b1DapGa17hsqG03o4Ia1mBkGn2DapGA")
        print(JSON.toJSONString(res))
    }

    private fun miniProgramClient(): MiniProgram {
        val weiXinConfig = WeiXinConfig()
        weiXinConfig.appId = "wx78791bd73b35a329";
        weiXinConfig.secret = "396ce9f67483adbc2044b987c069c599"
        return MiniProgram(weiXinConfig)
    }
}