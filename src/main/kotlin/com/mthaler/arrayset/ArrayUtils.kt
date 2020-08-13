package com.mthaler.arrayset

import kotlin.math.min

fun <T>newArray(n: Int, prototype: Array<T>): Array<T> {
    return java.lang.reflect.Array.newInstance(prototype.javaClass.componentType, n) as Array<T>
}

fun <T>resizeInPlace(a: Array<T>, n: Int): Array<T> {
    if (a.size == n) {
        return a
    } else {
        val r = newArray(n, a)
        System.arraycopy(a, 0, r, 0, min(n, a.size))
        return r
    }
}

fun <T : Comparable<T>>sortAndRemoveDuplicatesInPlace(a: Array<T>): Array<T> {
    if(a.size <= 1)
        return a
    else {
        Sorting.sort(a)
        var j = 1
        var i = 1
        while (i < a.size) {
            if (a[j-1].compareTo(a[i]) == 0) {
                a[j] = a[i]
                j += 1
            }
            i += 1
        }
        return resizeInPlace(a, j)
    }
}