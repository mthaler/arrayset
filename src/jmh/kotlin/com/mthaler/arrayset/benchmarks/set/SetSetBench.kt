package com.mthaler.arrayset.benchmarks.set

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class SetSetBench {

    @Param("1", "10", "100", "1000", "10000", "100000")
    var size = 0

    @Param("0.0", "0.5", "1.0")
    var offset = 0.0

    @Param("arrayset", "hashset", "sortedset")
    var kind = ""

    var k: Int = 0
    lateinit var bench: SetSetBenchOps

    val shift = 1000000 // so we don't get the cached java.lang.Integer instances

    @Setup
    fun setup() {
        k = (offset * size).toInt()
        bench = SetSetBenchOps.create((shift until (shift + size)).toList(), ((shift + k) until (shift + k + size)).toList(), kind)
    }

    @Benchmark
    fun union(x: Blackhole) {
        x.consume(bench!!.union())
    }

    @Benchmark
    fun intersect(x: Blackhole) {
        x.consume(bench.intersect())
    }

    @Benchmark
    fun diff(x: Blackhole) {
        x.consume(bench.diff())
    }

    @Benchmark
    fun subsetOf(x: Blackhole) {
        x.consume(bench.subsetOf())
    }

    @Benchmark
    fun filter(x: Blackhole) {
        x.consume(bench.filter { it < k + shift })
    }
}