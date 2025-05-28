package com.trionesdev.weixin.base.ex

open class WeiXinException : RuntimeException {
    private var code: String? = null

    constructor() : this(null, null, null)
    constructor(message: String) : this(null, message, null)
    constructor(code: String, message: String?) : this(code, message, null)

    constructor(code: String?, message: String?, cause: Throwable?) : super(message, cause) {
        this.code = code
    }
}