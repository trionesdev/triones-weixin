package com.trionesdev.weixin.miniprogram.model

import com.trionesdev.weixin.base.model.BaseResponse
import java.nio.ByteBuffer

class CreateQRCodeResponse : BaseResponse() {
    var buffer: ByteBuffer? = null
}