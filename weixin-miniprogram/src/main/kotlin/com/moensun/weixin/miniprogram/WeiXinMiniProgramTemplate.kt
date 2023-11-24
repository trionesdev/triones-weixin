package com.moensun.weixin.miniprogram

import com.moensun.weixin.commons.WeXinTemplate
import com.moensun.weixin.miniprogram.model.*

interface WeiXinMiniProgramTemplate:WeXinTemplate {
    fun code2Session(code: String): Code2SessionResponse

    fun checkEncryptedData(checkEncryptedDataRequest: CheckEncryptedDataRequest): CheckEncryptedDataResponse

    fun getUserPhoneNumber(getUserPhoneNumberRequest: GetUserPhoneNumberRequest): UserPhoneNumberResponse
}