package com.mthaler.arrayset.primitives

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntSortingTest {

    @Test
    fun insertionSort() {
        val a = intArrayOf(3, 2, 5, 4, 8, 12, 1)
        IntSorting.InsertionSort.sort(a, 0, a.size)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 8, 12), a)
    }

    @Test
    fun quickSort() {
        val a0 = intArrayOf(3, 2, 5, 4, 8, 12, 1)
        IntSorting.QuickSort.qsort(a0)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 8, 12), a0)
        val a1 = intArrayOf(20, 1, 19, 2, 18, 3, 17, 4, 16, 5, 15, 6, 14, 7, 13, 8, 12, 9, 11, 10)
        IntSorting.QuickSort.qsort(a1)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20), a1)
    }
}