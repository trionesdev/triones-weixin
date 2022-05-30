package com.moensun.weixin.commons.res

import com.fasterxml.jackson.annotation.JsonProperty

open class BaseResponse {
    @JsonProperty(value = "errcode")
    var errorCode:Long? = null
    @JsonProperty(value = "errmsg")
    var errorMsg:String? = null
}