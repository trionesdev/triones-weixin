package com.moensun.weixin.offiaccount

import com.fasterxml.jackson.databind.ObjectMapper
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.offiaccount.request.SendTemplateMessageRequest
import com.moensun.weixin.offiaccount.request.UserListRequest
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
    fun sendTemplateMessage_test() {
        val oa = officeAccount()
        val res = oa.getAccessToken()
        val req = SendTemplateMessageRequest().apply {
            accessToken = res.accessToken
            templateId = "O82xLO6vucU2MIySEzXgETtxSpXZYF75dqt2eZQCdMI"
            toUser = "ofSHFjroAmrv-CSGkmsRPcnEpp9Y"
            data = mutableMapOf("first" to SendTemplateMessageRequest.ParamValue(value = "100"))
        }
        val resSend = oa.sendTemplateMessage(req)
        print(ObjectMapper().writeValueAsString(resSend))
    }

    @Test
    fun getUserList_test() {
        val oa = officeAccount()
        val res = oa.getAccessToken()
        val result = oa.getUserList(UserListRequest().apply {
            accessToken = res.accessToken
        })
        print(ObjectMapper().writeValueAsString(result))
    }

    private fun officeAccount(): OfficeAccount {
        val weiXinConfig = WeiXinConfig()
        weiXinConfig.appId = "wx2cfd99d03e6000b5";
        weiXinConfig.secret = "c2ca264b9f232ce1e70533c5492caa78"
        return OfficeAccount(weiXinConfig)
    }

}