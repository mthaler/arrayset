package com.mthaler.arrayset.primitives

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntArraySetTest {
    @Test
    fun contains() {
        val a = intArrayOf(1, 4, 3, 7, 10, 7)
        val s = IntArraySet(a)
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
        val s0 = IntArraySet.of(1, 2, 3, 4).union(IntArraySet.of(3, 4, 5, 6))
        assertEquals(IntArraySet.of(1, 2, 3, 4, 5, 6), s0)
    }

    @Test
    fun intersect() {
        val s0 = IntArraySet.of(1, 2, 3, 4).intersect(IntArraySet.of(3, 4, 5, 6))
        assertEquals(IntArraySet.of(3, 4), s0)
    }
}