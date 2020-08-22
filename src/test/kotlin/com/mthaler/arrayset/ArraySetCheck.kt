package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class ArraySetCheck: StringSpec({

    "union" {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            val s = s1.union(s2)
            s == a.union(b)
        }
    }

    "intersection" {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            val s = s1.intersect(s2)
            s == a.intersect(b)
        }
    }

    "diff"  {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            val s = s1.diff(s2)
            s == a.subtract(b)
        }
    }
})