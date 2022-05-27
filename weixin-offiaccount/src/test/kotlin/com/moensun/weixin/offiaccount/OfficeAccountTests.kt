package com.moensun.weixin.offiaccount

import com.moensun.weixin.commons.WeiXinConfig
import org.junit.jupiter.api.Test
import kotlin.test.assertNull

class OfficeAccountTests {


    @Test
    fun getAccountToken_test() {
        val oa = officeAccount()
        val res = oa.getAccessToken()
        assertNull(res.errorCode)
    }

    @Test
    fun sendTemplateMessage(){
        val oa = officeAccount()
        val res = oa.getAccessToken()
        val req = SendTemplateMessageRequest()
        oa.sendTemplateMessage(req)
    }

    private fun officeAccount(): OfficeAccount {
        val weiXinConfig = WeiXinConfig()
        weiXinConfig.appId = "wx2cfd99d03e6000b5";
        weiXinConfig.secret = "c2ca264b9f232ce1e70533c5492caa78"
        return OfficeAccount(weiXinConfig)
    }

}