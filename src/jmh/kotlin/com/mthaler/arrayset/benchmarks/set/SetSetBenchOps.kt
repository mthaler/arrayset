package com.mthaler.arrayset.benchmarks.set

interface SetSetBenchOps {
    fun union(): Any
    fun intersect(): Any
    fun diff(): Any
    fun subsetOf(): Boolean
    fun filter(f: (Int) -> Boolean): Any
}