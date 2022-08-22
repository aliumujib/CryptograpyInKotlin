package com.aliumujib.android.cryptography.vigenerecipher

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


internal class VigenereCipherTest{

    private val sut = VigenereCipher()

    @Test
    fun encrypt() {
        val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val expectedCipherText = "FHCDN, QNUHCRR, ,O,VDQETY,V X,DN,GDK ,XNT, QNUD,INTQ,O,HMSZ,GGDM,X,T,BKHPJ,NMKVMD,UHQDN.,X,T,B MMO RSDMHM,SGR,DLADQ,BNCDMENQ,SUD,UHCRN,XNTMV MS,DN, CCK,XNT,P M, KCN,SXOR, ,JDIVNQC,DN,RD BBG,NMYHMD,E,Q,SGDMUHCDNMSG S,ODRS,EVSR,XNEQ,CNBELDMSZ"
        val cipherText = sut.encrypt(plainText, "Mujeeb")
        assertEquals(expectedCipherText, cipherText)
    }

    @Test
    fun encrypt_failure() {
        val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val expectedCipherText = ":"
        val cipherText = sut.encrypt(plainText, "Mujeeb")
        assertNotEquals(expectedCipherText, cipherText)
    }

    @Test
    fun decrypt() {
        val expectedPlainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val cipherText = "FHCDN, QNUHCRR, ,O,VDQETY,V X,DN,GDK ,XNT, QNUD,INTQ,O,HMSZ,GGDM,X,T,BKHPJ,NMKVMD,UHQDN.,X,T,B MMO RSDMHM,SGR,DLADQ,BNCDMENQ,SUD,UHCRN,XNTMV MS,DN, CCK,XNT,P M, KCN,SXOR, ,JDIVNQC,DN,RD BBG,NMYHMD,E,Q,SGDMUHCDNMSG S,ODRS,EVSR,XNEQ,CNBELDMSZ"
        val plainText = sut.decrypt(cipherText, "Mujeeb")
        assertEquals(expectedPlainText, plainText)
    }

    @Test
    fun decrypt_failure() {
        val expectedPlainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.".uppercase()
        val cipherText = ".NIJTEUWT.NIJXEFEUT,JWKZQE,FAEYTEMJQUEATZEUWT.JEATZWEUTNSYCE,MJSEATZEHQNHPETSQNSJE.NIJTDEATZEHFSEUFXYJENSEYMJEJRGJIEHTIJEKTWEYMJE.NIJTEATZE,FSYEYTEFIICEATZEHFSEFQXTEYAUJEFEPJA,TWIEYTEXJFWHMETSQNSJEKTWEYMJE.NIJTEYMFYEGJXYEKNYXEATZWEITHZRJSYC"
        val plainText = sut.decrypt(cipherText, "Mujeeb")
        assertNotEquals(expectedPlainText, plainText)
    }
}