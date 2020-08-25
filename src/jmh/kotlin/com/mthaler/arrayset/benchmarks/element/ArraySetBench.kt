package com.mthaler.arrayset.benchmarks.element

import com.mthaler.arrayset.ArraySet

data class ArraySetBench(val a: ArraySet<Int>, val c: Int, val n: Int) : SetElementBenchOps {

    override fun containsTrue(): Any = a.contains(c)

    override fun containsFalse(): Any = a.contains(n)
}