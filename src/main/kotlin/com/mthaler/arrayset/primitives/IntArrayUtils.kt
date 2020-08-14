package com.mthaler.arrayset.primitives

import kotlin.math.min

object IntArrayUtils {
    fun resizeInPlace(a: IntArray, n: Int): IntArray {
        if (a.size == n) {
            return a
        } else {
            val r = IntArray(n)
            System.arraycopy(a, 0, r, 0, min(n, a.size))
            return r
        }
    }

    fun sortAndRemoveDuplicatesInPlace(a: IntArray): IntArray {
        if(a.size <= 1)
            return a
        else {
            IntSorting.sort(a)
            var j = 1
            var i = 1
            while (i < a.size) {
                if (a[j-1].compareTo(a[i]) != 0) {
                    a[j] = a[i]
                    j += 1
                }
                i += 1
            }
            return resizeInPlace(a, j)
        }
    }
}