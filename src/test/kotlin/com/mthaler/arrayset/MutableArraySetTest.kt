package com.mthaler.arrayset

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MutableArraySetTest {

    @Test
    fun add() {
        val s = MutableArraySet.of(1, 4, 3, 7, 10, 7)
        assertTrue(s.add(8))
        assertEquals(MutableArraySet.of(1, 3, 4, 7, 8, 10), s)
        assertFalse(s.add(10))
        assertEquals(MutableArraySet.of(1, 3, 4, 7, 8, 10), s)
    }
}