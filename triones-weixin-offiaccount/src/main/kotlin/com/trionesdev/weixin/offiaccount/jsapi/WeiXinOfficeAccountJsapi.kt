package com.trionesdev.weixin.offiaccount.jsapi

import com.trionesdev.weixin.base.WeiXin
import com.trionesdev.weixin.base.WeiXinConfig
import com.trionesdev.weixin.base.http.HttpRequest
import com.trionesdev.weixin.base.sns.WeiXinSns
import com.trionesdev.weixin.base.util.DigestUtils
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiSignatureRequest
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiTicketRequest
import com.trionesdev.weixin.offiaccount.jsapi.model.JsapiTicketResponse
import okhttp3.OkHttpClient
import java.util.TreeMap

open class WeiXinOfficeAccountJsapi :WeiXin  {

    constructor(weiXinConfig: WeiXinConfig) : this(weiXinConfig, null)

    constructor(weiXinConfig: WeiXinConfig, httpClient: OkHttpClient?) : super(weiXinConfig, httpClient)

    /**
     * jsapi_ticket
     * https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html#4
     */
    fun getJsapiTicket(request: JsapiTicketRequest): JsapiTicketResponse {
        val httpRequest = HttpRequest.Builder().post()
            .url("cgi-bin/ticket/getticket?access_token=${accessToken(request.accessToken)}&type=${request.type}")
            .jsonBody(request)
            .build()
        return doExecute(httpRequest)
    }

    fun jsapiSignature(request: JsapiSignatureRequest): String? {
        val jsapiTicket = getJsapiTicket(JsapiTicketRequest()).ticket
        val treeMap = TreeMap<String, String?>()
        treeMap["noncestr"] = request.nonceStr
        treeMap["jsapi_ticket"] = jsapiTicket
        treeMap["url"] = request.url
        val strArr = arrayListOf<String>()
        treeMap.forEach { (t, u) -> strArr.add("${t}=${u}") }
        return DigestUtils.sha1(strArr.joinToString(separator = "&"))
    }

    protected fun jsapiTicket(ticket: String?): String? {
        return ticket?.let {
            return it
        } ?: let {
            return weiXinConfig.weiXinCache?.let {
                return it.getJsapiTicket(weiXinConfig.appId)
            }
        }
    }
}