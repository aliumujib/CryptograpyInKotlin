package com.aliumujib.android.cryptography.vigenerecipher

import com.aliumujib.android.cryptography.utils.Constants.ENGLISH_ALPHABET

class VigenereCipher {

    fun encrypt(plainText: String, key: String): String {
        return plainText.uppercase().foldIndexed("") { index, current, char ->
            val currentAlphabetIndex = ENGLISH_ALPHABET.indexOf(char)
            val keyChar = key[index % key.length]
            val cipherChar = Math.floorMod(currentAlphabetIndex + ENGLISH_ALPHABET.indexOf(keyChar), ENGLISH_ALPHABET.length)
            val next = current + ENGLISH_ALPHABET[cipherChar]
            next
        }
    }

    fun decrypt(cipherText: String, key: String): String {
        return cipherText.uppercase().foldIndexed("") { index, current, char ->
            val currentAlphabetIndex = ENGLISH_ALPHABET.indexOf(char)
            val keyChar = key[index % key.length]
            val cipherChar = Math.floorMod(currentAlphabetIndex - ENGLISH_ALPHABET.indexOf(keyChar), ENGLISH_ALPHABET.length)
            val next = current +  ENGLISH_ALPHABET[cipherChar]
            next
        }
    }
}