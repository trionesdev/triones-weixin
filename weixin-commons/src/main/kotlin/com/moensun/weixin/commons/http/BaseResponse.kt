package com.moensun.weixin.commons.http

import com.alibaba.fastjson.annotation.JSONField

open class BaseResponse {
    @JSONField(name = "errcode")
    var errorCode:Long? = null
    @JSONField(name = "errmsg")
    var errorMsg:String? = null
}