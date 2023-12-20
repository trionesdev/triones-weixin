package com.trionesdev.weixin.base.util

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class DigestUtils {

    companion object {
        fun sha1(data: String): String? {
            try {
                val digest = MessageDigest.getInstance("SHA-1")
                val hashBytes = digest.digest(data.toByteArray(Charsets.UTF_8))

                // Convert the byte array to hexadecimal string representation
                val hexString = StringBuilder()
                for (hashByte in hashBytes) {
                    val hex = Integer.toHexString(0xff and hashByte.toInt())
                    if (hex.length == 1) hexString.append('0')
                    hexString.append(hex)
                }

                return hexString.toString()
            } catch (e: NoSuchAlgorithmException) {
                return null
            }
        }
    }


}