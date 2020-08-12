package com.mthaler.arrayset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SortingTest {

    @Test
    fun insertionSortComparator() {
        val a = arrayOf(3, 2, 5, 4, 8, 12, 1)
        Sorting.InsertionSort.sort(a, 0, 6, object : Comparator<Int> {
            override fun compare(x: Int, y: Int): Int {
                if (x > y) {
                    return 1
                } else if (x < y) {
                    return -1
                } else {
                    return 0
                }
            }
        })
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 8, 12), a)
    }
}