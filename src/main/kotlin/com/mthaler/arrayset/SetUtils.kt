package com.mthaler.arrayset

import kotlin.math.min

object SetUtils {

    fun <E : Comparable<E>>union(a: Array<E>, b: Array<E>): Array<E> =
        UnionMerge(a, b).result()

    fun  <E : Comparable<E>>intersection(a: Array<E>, b: Array<E>): Array<E> =
        IntersectionMerge(a, b).result()

    fun  <E : Comparable<E>> diff(a: Array<E>, b: Array<E>): Array<E> =
        DiffMerge(a, b).result()

    class UnionMerge<E : Comparable<E>>(val a: Array<E>, val b: Array<E>) : BinaryMerge() {
        val r = ArrayUtils.newArray(a.size + b.size, a)
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

        fun result(): Array<E> = ArrayUtils.resizeInPlace(r, ri)
    }

    class IntersectionMerge<E : Comparable<E>>(val a: Array<E>, val b: Array<E>) : BinaryMerge() {
        val r = ArrayUtils.newArray(min(a.size, b.size), a)
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

        fun result(): Array<E> = ArrayUtils.resizeInPlace(r, ri)
    }

    class DiffMerge<E : Comparable<E>>(val a: Array<E>, val b: Array<E>) : BinaryMerge() {
        val r = ArrayUtils.newArray(a.size, a)
        var ri: Int = 0

        init {
            merge0(0, a.size, 0, b.size)
        }

        override fun compare(ai: Int, bi: Int) = a[ai].compareTo(b[bi])

        override fun collision(ai: Int, bi: Int) {}

        override fun fromA(a0: Int, a1: Int, bi: Int){
            System.arraycopy(a, a0, r, ri, a1 - a0)
            ri += a1 - a0
        }

        override fun fromB(ai: Int, b0: Int, b1: Int) {}

        fun result(): Array<E> = ArrayUtils.resizeInPlace(r, ri)
    }
}