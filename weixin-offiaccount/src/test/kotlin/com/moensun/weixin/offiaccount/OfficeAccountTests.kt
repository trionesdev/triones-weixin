package com.moensun.weixin.offiaccount

import com.fasterxml.jackson.databind.ObjectMapper
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.offiaccount.request.GetBaseUserInfoRequest
import com.moensun.weixin.offiaccount.request.SendTemplateMessageRequest
import com.moensun.weixin.offiaccount.request.GetUserListRequest
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
        val result = oa.getUserList(GetUserListRequest().apply {
            accessToken = res.accessToken
        })
        println(ObjectMapper().writeValueAsString(result))
        result.data?.openId?.let { it ->
            it.forEach { oid ->
                val userInfo = oa.getUserBasicInformation(GetBaseUserInfoRequest().apply {
                    accessToken = res.accessToken
                    openId = oid
                })
                println(ObjectMapper().writeValueAsString(userInfo))
            }
        }
    }

    private fun officeAccount(): OfficeAccount {
        val weiXinConfig = WeiXinConfig()
//        weiXinConfig.appId = "wx2cfd99d03e6000b5";
//        weiXinConfig.secret = "c2ca264b9f232ce1e70533c5492caa78"
        weiXinConfig.appId = "wxa255afa69a12b414";
        weiXinConfig.secret = "f4778c545d95f05cd464d6e3773fd4e9"
        return OfficeAccount(weiXinConfig)
    }

}