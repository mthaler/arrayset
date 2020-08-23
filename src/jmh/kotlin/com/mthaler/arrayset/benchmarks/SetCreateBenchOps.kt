package com.mthaler.arrayset.benchmarks

interface SetCreateBenchOps {

    fun createBulk(): Any

    fun createElements(): Any

    companion object {

        fun create(a: List<Int>, kind: String): Any {
            val a1 = a.map { i -> BenchUtil.mix(i) }.toTypedArray()
            require(a1.size == a.size)
            when(kind) {
                "hashset" -> KotlinCollectionBench(a1, { a -> hashSetOf(*a) })
                "sortedset" -> KotlinCollectionBench(a1, { a -> sortedSetOf(*a) })
                "arrayset" -> ArraySetBench(a1)
            }
            TODO("not implemented")
        }
    }
}