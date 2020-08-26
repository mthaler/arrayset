package com.mthaler.arrayset.benchmarks.create

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class SetCreateBench {

    @Param("1", "10", "100", "1000", "10000", "100000")
    var size = 0

    @Param("arrayset", "hashset", "sortedset")
    var kind = ""

    lateinit var bench: SetCreateBenchOps

    @Setup
    fun setup(): Unit {
        bench = SetCreateBenchOps.create((0..size).toList(), kind)
    }

    @Benchmark
    fun createBulk(x: Blackhole): Unit = x.consume(bench.createBulk())

    @Benchmark
    fun createElements(x: Blackhole): Unit = x.consume(bench.createElements())
}