package com.mthaler.abc

object Searching {

    fun <T : Comparable<T>>search(a: Array<T>, from: Int, until: Int, item: T): Int {
        var first = from
        var last = until - 1
        while (first <= last) {
            val middle = (first + last) ushr 1
            val compare = a[middle].compareTo(item)
            if (compare < 0) first = middle + 1
            else if (compare > 0) last = middle - 1
            else return middle
        }
        return -first - 1
    }
}