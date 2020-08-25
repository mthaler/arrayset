package com.mthaler.arrayset.benchmarks.element

import com.mthaler.arrayset.ArraySet
import com.mthaler.arrayset.benchmarks.BenchUtil
import java.lang.IllegalArgumentException

interface SetElementBenchOps  {

    fun containsTrue(): Any

    fun containsFalse(): Any

    companion object {

        fun create(a: List<Int>, c: Int, n: Int, kind: String): SetElementBenchOps {
            val a1 = a.map { i -> BenchUtil.mix(i) }.toTypedArray()
            val c1 = BenchUtil.mix(c)
            val n1 = BenchUtil.mix(n)
            require(a1.size == a.size)
            return when(kind) {
                "hashset" -> KotlinCollectionBench(a1.toHashSet(), c1, n1)
                "sortedset" -> KotlinCollectionBench(a1.toSortedSet(), c1, n1)
                "arrayset" -> ArraySetBench(ArraySet.of(a1.toList()), c1, n1)
                else -> throw IllegalArgumentException("Unknown benachmark: " + kind)
            }
        }
    }
}