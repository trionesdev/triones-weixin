package com.moensun.weixin.offiaccount

import com.fasterxml.jackson.annotation.JsonIgnore

open class BaseRequest(

) {
    @JsonIgnore
    val accessToken:String? = null
}