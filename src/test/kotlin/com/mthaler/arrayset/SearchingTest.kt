package com.mthaler.arrayset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchingTest {

    @Test
    fun search() {
        val a0 = arrayOf(0, 1, 2, 3, 4, 5)
        assertEquals(2, Searching.search(a0, 0, a0.size, 2))
        val a1 = arrayOf(0, 2, 3, 6, 7, 9)
        assertEquals(-4, Searching.search(a1, 0, a1.size, 4))
    }
}