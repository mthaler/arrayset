package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class MutableArraySetCheck  : StringSpec({

    "add" {
        forAll<Set<Int>, Int> { a, b ->
            val s = MutableArraySet.of(a)
            s.add(b) == a.toMutableSet().add(b)
        }
    }
})