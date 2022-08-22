package com.aliumujib.android.cryptography.onetimepad

import com.aliumujib.android.cryptography.utils.Constants

class OneTimePad {

    fun encrypt(plainText: String, key: List<Int>): String {
        return plainText.uppercase().foldIndexed("") { index, current, char ->
            val plainTextIndex = Constants.ENGLISH_ALPHABET.indexOf(char)
            val encryptedIndex =
                Math.floorMod((plainTextIndex + key[index]), Constants.ENGLISH_ALPHABET.length)
            val next = current + Constants.ENGLISH_ALPHABET[encryptedIndex]
            next
        }
    }

    fun decrypt(plainText: String, key: List<Int>): String {
        return plainText.uppercase().foldIndexed("") { index, current, char ->
            val plainTextIndex = Constants.ENGLISH_ALPHABET.indexOf(char)
            val encryptedIndex =
                Math.floorMod((plainTextIndex - key[index]), Constants.ENGLISH_ALPHABET.length)
            val next = current + Constants.ENGLISH_ALPHABET[encryptedIndex]
            next
        }
    }

}

fun main() {
    val oneTimePad = OneTimePad()
    val random = RandomGenerator()

    val plainText = "Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document."
    val key = random.generateRandomSequence(plainText.length)

    val cipherText = oneTimePad.encrypt(plainText, key);
    println("ENCRYPTED: $cipherText")

    val decryptedText = oneTimePad.decrypt(cipherText, key)
    println("DECRYPTED: $decryptedText")
}