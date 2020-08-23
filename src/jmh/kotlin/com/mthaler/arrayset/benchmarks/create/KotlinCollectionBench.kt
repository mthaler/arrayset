package com.mthaler.arrayset.benchmarks.create

data class KotlinCollectionBench(val a: Array<Int>, val f: (Array<Int>) -> Any) :
    SetCreateBenchOps {

    override fun createBulk(): Any = f(a)

    override fun createElements(): Any = f(a)
}