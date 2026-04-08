package com.trionesdev.weixin.base.ex

open class WeiXinException(message: String, cause: Throwable?) : java.lang.RuntimeException(message, cause) {
    private var code: String? = null

    constructor(message: String) : this(message, null)

    constructor(code: String, message: String) : this(code, message, null)

    constructor(code: String, message: String, cause: Throwable?) : this(message, cause) {
        this.code = code
    }

}