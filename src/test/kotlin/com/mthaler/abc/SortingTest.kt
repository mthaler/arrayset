package com.mthaler.abc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortingTest {

    @Test
    fun insertionSort() {
        val a = arrayOf(3, 2, 5, 4, 8, 12, 1)
        Sorting.InsertionSort.sort(a, 0, a.size)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 8, 12), a)
    }

    @Test
    fun quickSort() {
        val a0 = arrayOf(3, 2, 5, 4, 8, 12, 1)
        Sorting.QuickSort.qsort(a0)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 8, 12), a0)
        val a1 = arrayOf(20, 1, 19, 2, 18, 3, 17, 4, 16, 5, 15, 6, 14, 7, 13, 8, 12, 9, 11, 10)
        Sorting.QuickSort.qsort(a1)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), a1)
    }
}