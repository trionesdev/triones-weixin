package com.moensun.weixin.offiaccount.request

class BaseUserInfoRequest :BaseRequest(){
    var openId: String? = null
    var lang:String = "zh_CN"
}