package com.moensun.weixin.commons.model

import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseRequest  {
    @JsonIgnore
    var accessToken:String? = null
}