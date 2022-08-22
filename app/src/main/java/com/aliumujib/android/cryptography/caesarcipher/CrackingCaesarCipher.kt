package com.aliumujib.android.cryptography.caesarcipher

import com.aliumujib.android.cryptography.utils.Constants.ENGLISH_ALPHABET

class CrackingCaesarCipher {

    private val decryptor = CaesarCipher()

    /***
     * Demonstrates the serious problem with caesar cipher (outside of the fact that it is symmetric)
     * It can be cracked with very trival amounts of computing power because the number of possible guesses
     * for the key is pretty small
     */
    fun bruteForceCrack(cipherText: String) {
        for (key in 0..ENGLISH_ALPHABET.length) {
            println(decryptor.decrypt(cipherText, key))
        }
    }

    fun frequencyAnalysisCrack(cipherText: String): String {
        val mostFrequentCharacterInText = findMostFrequentCharacter(cipherText)!!
        val keyGuess =
            ENGLISH_ALPHABET.indexOf(mostFrequentCharacterInText) - ENGLISH_ALPHABET.indexOf(' ') //space is the most frequently occurring character of the english language
        return decryptor.decrypt(cipherText, keyGuess)
    }

    private fun findMostFrequentCharacter(text: String): Char? {
        val map = text.fold(mutableMapOf<Char, Int>()) { current, char ->
            current.apply {
                put(char, current.getOrDefault(char, 1) + 1)
            }
        }
        return map.maxByOrNull { it.value }?.key
    }

}