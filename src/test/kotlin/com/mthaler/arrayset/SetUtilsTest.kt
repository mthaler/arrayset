package com.mthaler.arrayset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetUtilsTest {

    @Test
    fun union() {
        val a0 = SetUtils.union(arrayOf(1, 2, 3, 4), arrayOf(3, 4, 5, 6))
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6), a0)
        val a1 = SetUtils.union(arrayOf(1, 2), arrayOf(5, 6))
        assertArrayEquals(arrayOf(1, 2, 5, 6), a1)
        val a2 = SetUtils.union(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3, 4))
        assertArrayEquals(arrayOf(1, 2, 3 ,4), a2)
    }
}