package com.trionesdev.weixin.base.sns

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.trionesdev.weixin.base.model.BaseResponse

@JsonIgnoreProperties(ignoreUnknown = true)
class SnsUserInfoResponse : BaseResponse() {
    @JsonProperty(value = "openid")
    var openId: String? = null
    var nickname: String? = null
    var sex: Int? = null
    var province: String? = null
    var city: String? = null
    var country: String? = null

    @JsonProperty(value = "headimgurl")
    var headImgUrl: String? = null
    var privilege: MutableList<String>? = null

    @JsonProperty(value = "unionid")
    var unionId: String? = null

    companion object {
        @JvmStatic
        fun builder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val response: SnsUserInfoResponse = SnsUserInfoResponse()

        fun openId(openId: String?): Builder {
            response.openId = openId
            return this
        }

        fun nickname(nickname: String?): Builder {
            response.nickname = nickname
            return this
        }

        fun sex(sex: Int?): Builder {
            response.sex = sex
            return this
        }

        fun province(province: String?): Builder {
            response.province = province
            return this
        }

        fun city(city: String?): Builder {
            response.city = city
            return this
        }

        fun country(country: String?): Builder {
            response.country = country
            return this
        }

        fun headImgUrl(headImgUrl: String?): Builder {
            response.headImgUrl = headImgUrl
            return this
        }

        fun privilege(privilege: MutableList<String>?): Builder {
            response.privilege = privilege
            return this
        }

        fun unionId(unionId: String?): Builder {
            response.unionId = unionId
            return this
        }

        fun build() = response
    }
}