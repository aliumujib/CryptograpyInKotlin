package com.aliumujib.android.cryptography.caesarcipher

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


class CaesarCipherTest {

    private val sut = CaesarCipher()

    @Test
    fun encrypt() {
        val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val expectedCipherText = ".NIJTEUWT.NIJXEFEUT,JWKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val cipherText = sut.encrypt(plainText, 5)
        assertEquals(expectedCipherText, cipherText)
    }

    @Test
    fun encrypt_failure() {
        val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val expectedCipherText = ":"
        val cipherText = sut.encrypt(plainText, 5)
        assertNotEquals(expectedCipherText, cipherText)
    }

    @Test
    fun decrypt() {
        val expectedPlainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val cipherText = ".NIJTEUWT.NIJXEFEUT,JWKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val plainText = sut.decrypt(cipherText, 5)
        assertEquals(expectedPlainText, plainText)
    }

    @Test
    fun decrypt_failure() {
        val expectedPlainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val cipherText = ".NIJTEUWT.NIJXEFEUT,JWKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val plainText = sut.decrypt(cipherText, 3)
        assertNotEquals(expectedPlainText, plainText)
    }
}