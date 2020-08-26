package com.mthaler.arrayset.benchmarks.set

import com.mthaler.arrayset.ArraySet
import com.mthaler.arrayset.benchmarks.BenchUtil
import java.lang.IllegalArgumentException

interface SetSetBenchOps {
    fun union(): Any
    fun intersect(): Any
    fun diff(): Any
    fun subsetOf(): Boolean
    fun filter(f: (Int) -> Boolean): Any

    companion object {

        fun create(a: List<Int>, b: List<Int>, kind: String): SetSetBenchOps {
            val a1 = a.map { i -> BenchUtil.mix(i) }.toTypedArray()
            val b1 = b.map { i -> BenchUtil.mix(i) }.toTypedArray()
            return when(kind) {
                "hashset" -> KotlinCollectionBench(a1.toHashSet(), b1.toHashSet())
                "sortedset" -> KotlinCollectionBench(a1.toSortedSet(), b1.toSortedSet())
                "arrayset" -> ArraySetBench(ArraySet.of(a1.toList()), ArraySet.of(b1.toList()))
                else -> throw IllegalArgumentException("Unknown benachmark: " + kind)
            }
        }
    }
}