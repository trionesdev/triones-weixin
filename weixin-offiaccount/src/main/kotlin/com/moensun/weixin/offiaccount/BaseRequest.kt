package com.moensun.weixin.offiaccount

import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseRequest  {
    @JsonIgnore
    var accessToken:String? = null
}