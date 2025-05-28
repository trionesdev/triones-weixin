package com.trionesdev.weixin.miniprogram.model

class GetQRCodeRequest {
    var appId: String? = null
    var accessToken: String? = null
    var path: String? = null
    var width: Int? = null
    var autoColor: Boolean? = null
    var lineColor: Rgb? = null
    var hyaline: Boolean? = null
    var envVersion: String? = null
}