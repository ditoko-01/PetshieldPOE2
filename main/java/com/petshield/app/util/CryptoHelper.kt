package com.petshield.app.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

// Simple AES/CBC/PKCS5 example for local encryption (not for production secrets).
object CryptoHelper {
    // 16-byte key (for demo). In production store this securely (keystore).
    private const val KEY = "0123456789ABCDEF" // MUST be 16 chars
    private const val IV = "ABCDEF0123456789"  // 16-char IV

    fun encrypt(plain: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec = SecretKeySpec(KEY.toByteArray(), "AES")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, IvParameterSpec(IV.toByteArray()))
        val encrypted = cipher.doFinal(plain.toByteArray())
        return Base64.encodeToString(encrypted, Base64.DEFAULT)
    }

    fun decrypt(b64: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec = SecretKeySpec(KEY.toByteArray(), "AES")
        cipher.init(Cipher.DECRYPT_MODE, keySpec, IvParameterSpec(IV.toByteArray()))
        val decoded = Base64.decode(b64, Base64.DEFAULT)
        return String(cipher.doFinal(decoded))
    }
}
