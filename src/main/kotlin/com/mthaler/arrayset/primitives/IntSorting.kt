package com.mthaler.arrayset.primitives

object IntSorting {

    object InsertionSort {

        fun sort(data: IntArray, start: Int, end: Int) {
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

    object QuickSort {
        val limit: Int = 16

        fun qsort(data: IntArray) {
            qsort(data, 0, data.size - 1)
        }

        fun qsort(data: IntArray, left: Int, right: Int) {
            if (right - left < limit)
                InsertionSort.sort(data, left, right + 1)
            else {
                val pivot = left + (right - left) / 2
                val next = partition(data, left, right, pivot)
                qsort(data, left, next - 1)
                qsort(data, next + 1, right)
            }
        }

        fun partition(data: IntArray, left: Int, right: Int, pivot: Int): Int {
            val value = data[pivot]

            //swap(pivot, right)
            var tmp = data[pivot]; data[pivot] = data[right]; data[right] = tmp

            var store = left
            var i = left

            while (i < right) {
                if (data[i].compareTo(value) < 0) {
                    //swap(i, store)
                    tmp = data[i]; data[i] = data[store]; data[store] = tmp
                    store += 1
                }
                i += 1
            }

            //swap(store, right)
            tmp = data[store]; data[store] = data[right]; data[right] = tmp
            return store
        }
    }

    fun sort(data: IntArray) {
        QuickSort.qsort(data)
    }
}