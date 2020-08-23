package com.mthaler.arrayset.benchmarks

import com.mthaler.arrayset.ArraySet

data class ArraySetBench(val a: Array<Int>) : SetCreateBenchOps {

    override fun createBulk(): Any = {
        ArraySet(a)
    }

    override fun createElements(): Any = {
        a.fold(ArraySet.empty<Int>()) { x, y -> x + y }
    }
}