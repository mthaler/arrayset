package com.mthaler.arrayset.benchmarks

import org.apache.commons.codec.digest.MurmurHash3

object BenchUtil {

    fun mix(x: Int) = MurmurHash3.hash32(x.toLong())
}