package com.mthaler.arrayset

import kotlin.math.min

fun <T>resizeInPlace(a: Array<T>, n: Int): Array<T> {
    if (a.size == n) {
        return a
    } else {
        val r = newArray(n, a)
        System.arraycopy(a, 0, r, 0, min(n, a.size))
        return r
    }
}

fun <T>newArray(n: Int, prototype: Array<T>): Array<T> {
    return java.lang.reflect.Array.newInstance(prototype.javaClass.componentType, n) as Array<T>
}