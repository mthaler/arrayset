package com.mthaler.abc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArraySetTest {

    @Test
    fun contains() {
        val a = arrayOf(1, 4, 3, 7, 10, 7)
        val s = ArraySet(a)
        for (elem in a) {
            assertTrue(s.contains(elem))
        }
        assertFalse(s.contains(0))
        assertFalse(s.contains(2))
        assertFalse(s.contains(5))
        assertFalse(s.contains(8))
        assertFalse(s.contains(9))
        assertFalse(s.contains(11))
    }

    @Test
    fun union() {
        val s0 = ArraySet.of(1, 2, 3, 4).union(ArraySet.of(3, 4, 5, 6))
        assertEquals(ArraySet.of(1, 2, 3, 4, 5, 6), s0)
    }
}