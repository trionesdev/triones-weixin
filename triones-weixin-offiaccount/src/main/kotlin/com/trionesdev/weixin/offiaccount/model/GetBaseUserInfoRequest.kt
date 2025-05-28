package com.trionesdev.weixin.offiaccount.model

class GetBaseUserInfoRequest :BaseRequest(){
    var appId: String? = null
    var openId: String? = null
    var lang:String = "zh_CN"
}