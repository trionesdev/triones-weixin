package com.moensun.weixin.miniprogram.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.moensun.weixin.commons.res.BaseResponse

class CheckEncryptedDataResponse : BaseResponse() {
    var vaild: Boolean? = null

    @JsonProperty(value = "create_time")
    var createTime: Long? = null
}