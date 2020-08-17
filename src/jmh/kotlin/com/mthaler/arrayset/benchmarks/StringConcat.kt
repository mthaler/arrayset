package com.mthaler.arrayset.benchmarks

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Mode.All) // test in all available modes
@Warmup(iterations = 10) // number of iterations to warmup Java Virtual Machine
@Measurement(iterations = 100, batchSize = 10) // number of measurement operations, each one have 10 our test method calls
open class StringConcat {

    @Benchmark
    fun stringConcat(blackhole: Blackhole) {
        var s = ""
        for (i in 0..1000) {
            s += i
        }
        blackhole.consume(s)
    }
}