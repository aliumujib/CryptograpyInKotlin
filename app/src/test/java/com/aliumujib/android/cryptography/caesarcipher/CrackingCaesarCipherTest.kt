package com.aliumujib.android.cryptography.caesarcipher

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


internal class CrackingCaesarCipherTest{
    private val sut = CrackingCaesarCipher()

    @Test
    fun frequencyAnalysisCrack_success(){
        val expectedPlainText = "VIDEO PROVIDES A POWERFUL WAY TO HELP YOU PROVE YOUR POINT. WHEN YOU CLICK ONLINE VIDEO, YOU CAN PASTE IN THE EMBED CODE FOR THE VIDEO YOU WANT TO ADD. YOU CAN ALSO TYPE A KEYWORD TO SEARCH ONLINE FOR THE VIDEO THAT BEST FITS YOUR DOCUMENT.".uppercase()
        val cipherText = ".NIJTEUWT.NIJXEFEUT,JWKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val plainText = sut.frequencyAnalysisCrack(cipherText)
        assertEquals(expectedPlainText, plainText)
    }

    @Test
    fun frequencyAnalysisCrack_failure(){
        val expectedPlainText = "VIDEO PROVIDES A POWERFUL WAY TO HELP YOU PROVE YOUR POINT. WHEN YOU CLICK ONLINE VIDEO, YOU CAN PASTE IN THE EMBED CODE FOR THE VIDEO YOU WANT TO ADD. YOU CAN ALSO TYPE A KEYWORD TO SEARCH ONLINE FOR THE VIDEO THAT BEST FITS YOUR DOCUMENT.".uppercase()
        val cipherText = "WKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val plainText = sut.frequencyAnalysisCrack(cipherText)
        assertNotEquals(expectedPlainText, plainText)
    }
}