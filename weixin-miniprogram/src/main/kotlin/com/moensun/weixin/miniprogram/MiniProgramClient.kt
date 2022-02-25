package com.moensun.weixin.miniprogram

import com.alibaba.fastjson.JSON
import com.moensun.weixin.commons.WeiXinConfig
import com.moensun.weixin.commons.http.WeiXinHttpClient
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MiniProgramClient(weiXinConfig: WeiXinConfig): WeiXinHttpClient(weiXinConfig) {
    var httpClient: OkHttpClient? = null

    init {
        this.httpClient = OkHttpClient()
    }

   fun getAccessToken(req: AccessTokenRequest):AccessTokenResponse{
       val res: Response? =  this.httpClient?.newCall(Request.Builder().method("GET",null)
           .url("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+this.weiXinConfig.appId+"&secret="+this.weiXinConfig.secret).build())?.execute();
      return JSON.parseObject(res?.body?.string(),AccessTokenResponse::class.java)
   }

}