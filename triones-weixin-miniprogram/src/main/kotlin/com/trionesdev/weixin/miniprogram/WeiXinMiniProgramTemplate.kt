package com.trionesdev.weixin.miniprogram

import com.trionesdev.weixin.base.WeXinTemplate
import com.trionesdev.weixin.miniprogram.model.*
import java.nio.ByteBuffer

interface WeiXinMiniProgramTemplate : WeXinTemplate {
    fun code2Session(code: String): Code2SessionResponse

    fun checkEncryptedData(checkEncryptedDataRequest: CheckEncryptedDataRequest): CheckEncryptedDataResponse

    fun getUserPhoneNumber(getUserPhoneNumberRequest: GetUserPhoneNumberRequest): UserPhoneNumberResponse

    fun getQRCode(getQRCodeRequest: GetQRCodeRequest): ByteArray?

    fun createQRCode(createQRCodeRequest: CreateQRCodeRequest): ByteArray?
}