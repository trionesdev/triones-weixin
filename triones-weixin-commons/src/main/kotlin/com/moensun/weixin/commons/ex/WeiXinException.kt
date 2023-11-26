package com.moensun.weixin.commons.ex

class WeiXinException : RuntimeException {
    private var code: String? = null

    constructor() : this(null, null, null)
    constructor(code: String) : this(code, null, null)
    constructor(code: String, message: String) : this(code, message, null)

    constructor(code: String?, message: String?, cause: Throwable?) : super(message, cause) {
        this.code = code
    }
}