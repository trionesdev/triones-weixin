package com.moensun.weixin.offiaccount.request

class GetBaseUserInfoRequest :BaseRequest(){
    var openId: String? = null
    var lang:String = "zh_CN"
}