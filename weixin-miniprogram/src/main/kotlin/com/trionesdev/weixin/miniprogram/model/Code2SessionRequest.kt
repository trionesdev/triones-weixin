package com.trionesdev.weixin.miniprogram.model

class Code2SessionRequest {
    /**
     * appId 如果项目中配置了多个微信账号，需要传入对应的AppId
     */
    var appId: String? = null

    /**
     * 小程序端通过 wx.login 获得的code
     */
    var code: String? = null

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {
        var request = Code2SessionRequest()
        fun appId(appId: String?) = apply { request.appId = appId }
        fun code(code: String?) = apply { request.code = code }
        fun build() = request
    }
}