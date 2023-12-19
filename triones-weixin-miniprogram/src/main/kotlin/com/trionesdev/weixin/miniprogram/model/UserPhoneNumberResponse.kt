package com.trionesdev.weixin.miniprogram.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

class UserPhoneNumberResponse : BaseResponse() {
    @JsonProperty(value = "phone_info")
    var phoneInfo: PhoneInfo? = null
    class PhoneInfo{
        var phoneNumber:String? = null
        var purePhoneNumber:String? = null
        var countryCode:String? = null
        var watermark:Watermark? = null

        class Watermark{
            var timestamp:Long? = null
            var appid:String? = null
        }
    }
}