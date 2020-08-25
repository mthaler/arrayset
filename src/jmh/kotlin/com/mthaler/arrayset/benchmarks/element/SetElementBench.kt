package com.mthaler.arrayset.benchmarks.element

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class SetElementBench {

    @Param("1", "10", "100", "1000", "10000", "100000")
    var size = 0

    @Param("arrayset", "hashset", "sortedset")
    var kind = ""

    var k: Int = 0
    var bench: SetElementBenchOps? = null

    @Setup
    fun setup(): Unit {
        val c = (0.3 * size).toInt() // a value that is contained in the set
        val n = (1.3 * size).toInt() // a value that is not contained in the set
        bench = SetElementBenchOps.create((0..size).toList(), c, n, kind)
    }
}