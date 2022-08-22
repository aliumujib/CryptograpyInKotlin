package com.aliumujib.android.cryptography.caesarcipher

import com.aliumujib.android.cryptography.utils.Constants.ENGLISH_ALPHABET

class CaesarCipher {

    //encryption: E(x) = (X + n) % S (x: cipher text, n: key, S: size of alphabet)
    fun encrypt(plainText: String, key: Int): String {
        return plainText.uppercase().fold("") { current, char ->
            val index = ENGLISH_ALPHABET.indexOf(char)
            val encryptedIndex = Math.floorMod((index + key), ENGLISH_ALPHABET.length)
            val next = current + ENGLISH_ALPHABET[encryptedIndex]
            next
        }
    }

    //decryption: E(x) = (X - n) % S
    fun decrypt(cipherText: String, key: Int): String {
        return cipherText.uppercase().fold("") { current, char ->
            val index = ENGLISH_ALPHABET.indexOf(char)
            val encryptedIndex = Math.floorMod((index - key), ENGLISH_ALPHABET.length)
            val next = current + ENGLISH_ALPHABET[encryptedIndex]
            next
        }
    }

}