package com.mthaler.arrayset.benchmarks.set

import com.mthaler.arrayset.ArraySet

data class ArraySetBench(val a: ArraySet<Int>, val b: ArraySet<Int>) : SetSetBenchOps {
    override fun union(): Any = a union b

    override fun intersect(): Any = a intersect b

    override fun diff(): Any = a diff b

    override fun subsetOf(): Boolean = a subsetOf b

    override fun filter(f: (Int) -> Boolean): Any = a.filter(f)
}