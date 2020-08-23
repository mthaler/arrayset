package com.mthaler.arrayset.benchmarks

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class SetCreateBench {

    @Param("1", "10", "100", "1000", "10000", "100000")
    var size = 0

    @Param("arrayset", "hashset", "sortedset")
    var kind = ""

    var bench: SetCreateBenchOps? = null

    @Setup
    fun setup(): Unit {
        bench = SetCreateBenchOps.create((0..size).toList(), kind)
    }
}