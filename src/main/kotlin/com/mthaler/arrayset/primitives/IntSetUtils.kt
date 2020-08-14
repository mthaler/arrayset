package com.mthaler.arrayset.primitives

import com.mthaler.arrayset.BinaryMerge
import kotlin.math.min
import com.mthaler.arrayset.SetUtils.AbortControl
import com.mthaler.arrayset.SetUtils.abort

object IntSetUtils {

    fun union(a: IntArray, b: IntArray): IntArray =
        UnionMerge(a, b).result()

    fun  intersection(a: IntArray, b: IntArray): IntArray =
        IntersectionMerge(a, b).result()

    fun   diff(a: IntArray, b: IntArray): IntArray =
        DiffMerge(a, b).result()

    fun xor(a: IntArray, b: IntArray): IntArray =
        XorMerge(a, b).result()

    fun subsetOf(a: IntArray, b: IntArray): Boolean {
        try {
            SubsetOf(a, b)
            return true
        } catch(x: AbortControl) {
            return false
        }
    }

    fun intersects(a: IntArray, b: IntArray): Boolean {
        try {
            NoIntersect(a, b)
            return false
        } catch(x: AbortControl) {
            return true
        }
    }

    class UnionMerge(val a: IntArray, val b: IntArray) : BinaryMerge() {
        val r = IntArray(a.size + b.size)
        var ri: Int = 0

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {
            System.arraycopy(a, ai, r, ri, 1)
            ri += 1
        }

        override fun fromA(a0: Int, a1: Int, bi: Int) {
            System.arraycopy(a, a0, r, ri, a1 - a0)
            ri += a1 - a0
        }

        override fun fromB(ai: Int, b0: Int, b1: Int) {
            System.arraycopy(b, b0, r, ri, b1 - b0)
            ri += b1 - b0
        }

        fun result(): IntArray = IntArrayUtils.resizeInPlace(r, ri)
    }

    class IntersectionMerge(val a: IntArray, val b: IntArray) : BinaryMerge() {
        val r = IntArray(min(a.size, b.size))
        var ri: Int = 0

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {
            System.arraycopy(a,ai,r,ri,1)
            // r(ri) = a(ai)
            ri += 1
        }
        override fun fromA(a0: Int, a1: Int, bi: Int) {}

        override fun fromB(ai: Int, b0: Int, b1: Int) {}

        fun result(): IntArray = IntArrayUtils.resizeInPlace(r, ri)
    }

    class DiffMerge(val a: IntArray, val b: IntArray) : BinaryMerge() {
        val r = IntArray(a.size)
        var ri: Int = 0

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {}

        override fun fromA(a0: Int, a1: Int, bi: Int) {
            System.arraycopy(a, a0, r, ri, a1 - a0)
            ri += a1 - a0
        }

        override fun fromB(ai: Int, b0: Int, b1: Int) {}

        fun result(): IntArray = IntArrayUtils.resizeInPlace(r, ri)
    }

    class XorMerge(val a: IntArray, val b: IntArray) : BinaryMerge() {
        var ri: Int = 0
        val r = IntArray(a.size + b.size)

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {}

        override fun fromA(a0: Int, a1: Int, bi: Int) {
            System.arraycopy(a, a0, r, ri, a1 - a0)
            ri += a1 - a0
        }
        override fun fromB(ai: Int, b0: Int, b1: Int) {
            System.arraycopy(b, b0, r, ri, b1 - b0)
            ri += b1 - b0
        }

        fun result(): IntArray = IntArrayUtils.resizeInPlace(r, ri)
    }

    class SubsetOf(val a: IntArray, val b: IntArray) : BinaryMerge() {

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {}

        override fun fromA(a0: Int, a1: Int, bi: Int) {
            throw abort
        }

        override fun fromB(ai: Int, b0: Int, b1: Int) {}
    }

    class NoIntersect(val a: IntArray, val b: IntArray) : BinaryMerge() {

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) { throw abort }

        override fun fromA(a0: Int, a1: Int, bi: Int) {}

        override fun fromB(ai: Int, b0: Int, b1: Int) {}
    }
}