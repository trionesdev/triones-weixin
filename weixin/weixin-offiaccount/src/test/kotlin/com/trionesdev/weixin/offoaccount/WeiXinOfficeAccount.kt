package com.trionesdev.weixin.offoaccount

import org.junit.jupiter.api.Test
import java.util.TreeMap

class WeiXinOfficeAccount {

    @Test
    fun sign_test(){
        var treeMap = TreeMap<String,String>()
        treeMap["noncestr"] = "111"
        treeMap["jsapi_ticket"] = "111"
        treeMap["timestamp"] = "111"
        treeMap["url"] = "111"


        treeMap.forEach(action = {it->
            run {
                println(it.key)
            }
        })

        var strArr = arrayListOf<String>()
        treeMap.forEach { (t, u) ->
            strArr.add("${t}=${u}")
        }

        println(strArr.joinToString(separator = "&"))
    }
}