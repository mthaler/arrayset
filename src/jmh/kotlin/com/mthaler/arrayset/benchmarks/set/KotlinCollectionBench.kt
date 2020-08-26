package com.mthaler.arrayset.benchmarks.set

data class KotlinCollectionBench(val a: Set<Int>, val b: Set<Int>) : SetSetBenchOps {

    override fun union(): Any = a union  b

    override fun intersect(): Any = a intersect b

    override fun diff(): Any = a subtract b

    override fun subsetOf(): Boolean = a.intersect(b) == a

    override fun filter(f: (Int) -> Boolean): Any = a.filter(f)
}