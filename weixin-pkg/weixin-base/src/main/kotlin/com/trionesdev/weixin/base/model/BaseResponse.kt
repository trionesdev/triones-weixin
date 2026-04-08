package com.trionesdev.weixin.base.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
open class BaseResponse {
    @JsonProperty(value = "errcode")
    var errorCode:Long? = null
    @JsonProperty(value = "errmsg")
    var errorMsg:String? = null
}