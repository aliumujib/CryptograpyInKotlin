package com.aliumujib.android.cryptography.des

import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec

class DES {
    private val encryptCipher: Cipher
    private val decryptCipher: Cipher

    init {
        //not handling exceptions so that the program can fail loudly
        val secretKey = KeyGenerator.getInstance("DES").generateKey()
        val random = SecureRandom()
        encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding")
        decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding")
        val initializationVector = ByteArray(encryptCipher.blockSize)
        random.nextBytes(initializationVector)
        val ivParams = IvParameterSpec(initializationVector)
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams)
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams)
    }

    fun encrypt(plainText: String) : String{
        val plainTextBytes = plainText.encodeToByteArray()
        val cipherText =  encryptCipher.doFinal(plainTextBytes)
        return Base64.getEncoder().encodeToString(cipherText)
    }

    fun decrypt(cipherText: String) : String{
        val cipherTextBytes = cipherText.encodeToByteArray()
        val plainText =  decryptCipher.doFinal(Base64.getDecoder().decode(cipherTextBytes))
        return String(plainText, Charsets.UTF_8)
    }

}


fun main() {
    val des = DES()

    val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document."

    val cipherText = des.encrypt(plainText);
    println("ENCRYPTED: $cipherText")

    val decryptedText = des.decrypt(cipherText)
    println("DECRYPTED: $decryptedText")
}