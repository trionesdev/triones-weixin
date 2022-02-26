package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.annotation.JSONField
import com.moensun.weixin.commons.http.BaseResponse

class CheckEncryptedDataResponse : BaseResponse() {
    var vaild: Boolean? = null

    @JSONField(name = "create_time")
    var createTime: Long? = null
}