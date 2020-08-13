package com.mthaler.arrayset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayUtilsTest {
    @Test
    fun newArray() {
        val a0 = arrayOf(0, 1, 2, 3, 4, 5, 6, 7)
        val a1 = ArrayUtils.newArray(5, a0)
        assert(a1.size == 5)
    }

    @Test
    fun resizeInPlace() {
        val a0 = arrayOf(0, 1, 2, 3, 4, 5, 6, 7)
        val a1 = ArrayUtils.resizeInPlace(a0, 5)
        assertArrayEquals(arrayOf(0, 1, 2, 3, 4), a1)
    }
}