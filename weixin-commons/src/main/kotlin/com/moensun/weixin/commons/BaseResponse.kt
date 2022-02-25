package com.moensun.weixin.commons

import com.alibaba.fastjson.annotation.JSONField

open class BaseResponse {
    @JSONField(name = "errcode")
    var errorCode:String? = null
    @JSONField(name = "errmsg")
    var errorMsg:String? = null
}