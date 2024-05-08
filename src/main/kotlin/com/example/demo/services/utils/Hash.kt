package com.example.demo.services.utils

import java.math.BigInteger
import java.security.MessageDigest

/**
 * Utility class that computes hashes of String, bytes, etc.
 */
object Hash {

    private val md: MessageDigest = MessageDigest.getInstance("SHA1")
    private const val POSITIVE = 1

    @Synchronized
    fun digest(data: ByteArray?): ByteArray {
        md.reset()
        md.update(data)
        return md.digest()
    }

    fun of(data: String): String {
        return String.format("%016X", BigInteger(POSITIVE, digest(data.toByteArray())))
    }

    fun of(data: ByteArray?): String {
        return String.format("%016X", BigInteger(POSITIVE, digest(data)))
    }
}