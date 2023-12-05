package com.trionesdev.weixin.miniprogram.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.commons.model.BaseResponse

class CheckEncryptedDataResponse : BaseResponse() {
    var vaild: Boolean? = null

    @JsonProperty(value = "create_time")
    var createTime: Long? = null
}