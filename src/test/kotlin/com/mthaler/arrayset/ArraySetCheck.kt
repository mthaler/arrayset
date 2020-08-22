package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class ArraySetCheck: StringSpec({
    "String size" {
        forAll<String, String> { a, b ->
            (a + b).length == a.length + b.length
        }
    }

    "List size" {
        forAll<List<Int>, List<Int>> { a, b ->
            val result = ArrayList<Int>()
            result.addAll(a)
            result.addAll(b)
            result.size === a.size + b.size
        }
    }
})