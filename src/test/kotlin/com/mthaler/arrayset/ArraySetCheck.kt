package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class ArraySetCheck: StringSpec({

    "union" {
        forAll<List<Int>, List<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            val s = s1.union(s2)
            val expected = HashSet<Int>()
            expected.addAll(a)
            expected.addAll(b)
            s == expected
        }
    }
})