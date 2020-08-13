package com.mthaler.abc

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

    @Test
    fun sortAndRemoveDuplicatesInPlace() {
        val a0 = arrayOf(20, 1, 19, 2, 18, 3, 19, 17, 4, 16, 5, 16, 13, 15, 6, 6, 14, 7, 8, 13, 8, 12, 11, 9, 11, 10)
        val a1 = ArrayUtils.sortAndRemoveDuplicatesInPlace(a0)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), a1)
    }
}