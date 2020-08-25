package com.mthaler.arrayset.benchmarks.create

import com.mthaler.arrayset.benchmarks.BenchUtil
import java.lang.IllegalArgumentException

interface SetCreateBenchOps {

    fun createBulk(): Any

    fun createElements(): Any

    companion object {

        fun create(a: List<Int>, kind: String): SetCreateBenchOps {
            val a1 = a.map { i -> BenchUtil.mix(i) }.toTypedArray()
            require(a1.size == a.size)
            return when(kind) {
                "hashset" -> KotlinCollectionBench(a1, { a -> hashSetOf(*a) })
                "sortedset" -> KotlinCollectionBench(a1, { a -> sortedSetOf(*a) })
                "arrayset" -> ArraySetBench(a1)
                else -> throw IllegalArgumentException("Unknown benachmark: " + kind)
            }
        }
    }
}