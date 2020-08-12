package com.mthaler.arrayset

import java.util.Comparator

object Sorting {

    object InsertionSort {

        fun <T>sort(data: Array<T>, start: Int, end: Int, c: Comparator<T>) {
            var i = start + 1
            while (i < end) {
                val item = data[i]
                var hole = i
                while(hole > start && c.compare(data[hole - 1], item) > 0) {
                    data[hole] = data[hole - 1]
                    hole -= 1
                }
                data[hole] = item
                i += 1
            }
        }

        fun <T : Comparable<T>>sort(data: Array<T>, start: Int, end: Int) {
            var i = start + 1
            while (i < end) {
                val item = data[i]
                var hole = i
                while(hole > start && data[hole - 1].compareTo(item) > 0) {
                    data[hole] = data[hole - 1]
                    hole -= 1
                }
                data[hole] = item
                i += 1
            }
        }
    }
}