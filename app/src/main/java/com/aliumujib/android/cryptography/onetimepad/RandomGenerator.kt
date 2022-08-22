package com.aliumujib.android.cryptography.onetimepad

import kotlin.random.Random

class RandomGenerator {
    fun generateRandomSequence(range: Int): List<Int> {
        val random = Random(range)
        return (0..range).map {
            random.nextInt()
        }.toList()
    }
}