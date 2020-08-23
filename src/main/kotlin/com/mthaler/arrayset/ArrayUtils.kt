package com.mthaler.arrayset

import kotlin.math.min

object ArrayUtils {

    fun <T>newArray(n: Int, prototype: Array<T>): Array<T> {
        return java.lang.reflect.Array.newInstance(prototype.javaClass.componentType, n) as Array<T>
    }

    fun <T : Any>newArray(n: Int, prototype: Collection<T>): Array<T> {
        val componentType = prototype.first().javaClass
        return java.lang.reflect.Array.newInstance(componentType, n) as Array<T>
    }

    fun <T : Any>toArray(c: Collection<T>): Array<T> {
        val a = newArray(c.size, c)
        var i = 0
        for(elem in c) {
            a[i] = elem
            i++
        }
        return a
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
                if (a[j-1].compareTo(a[i]) != 0) {
                    a[j] = a[i]
                    j += 1
                }
                i += 1
            }
            return resizeInPlace(a, j)
        }
    }

    fun <T>singleton(value: T, prototype: Array<T>): Array<T> {
        val result = java.lang.reflect.Array.newInstance(prototype.javaClass.componentType, 1) as Array<T>
        result[0] = value
        return result
    }
}