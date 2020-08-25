package com.mthaler.arrayset.benchmarks.element

data class KotlinCollectionBench(val a: Set<Int>, val c: Int, val n: Int) : SetElementBenchOps {

    override fun containsTrue(): Any = a.contains(c)

    override fun containsFalse(): Any = a.contains(n)
}