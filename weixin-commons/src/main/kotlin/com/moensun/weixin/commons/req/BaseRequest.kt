package com.moensun.weixin.commons.req

import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseRequest  {
    @JsonIgnore
    var accessToken:String? = null
}