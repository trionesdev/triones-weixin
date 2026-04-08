package com.trionesdev.weixin.offiaccount.model

import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseRequest  {
    var appId: String? = null
    @JsonIgnore
    var accessToken:String? = null
}