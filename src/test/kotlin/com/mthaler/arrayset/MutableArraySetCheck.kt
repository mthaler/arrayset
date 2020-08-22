package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class MutableArraySetCheck  : StringSpec({

    "add" {
        forAll<Set<Int>, Int> { a, b ->
            val s1 = MutableArraySet.of(a)
            val s2 = HashSet<Int>(a)
            s1.add(b) == s2.add(b) && s1 as Set<Int> == s2
        }
    }

    "remove" {
        forAll<Set<Int>, Int> { a, b ->
            val s1 = MutableArraySet.of(a)
            val s2 = HashSet<Int>(a)
            s1.remove(b) == s2.remove(b) && s1 as Set<Int> == s2
        }
    }
})