package com.mthaler.arrayset

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class ArraySetCheck : StringSpec({

    "size"  {
        forAll<List<Int>> { a ->
            val s = ArraySet.of(a)
            s.size == a.toSet().size
        }
    }

    "contains" {
        forAll<Set<Int>, Int> { a, b ->
            val s = ArraySet.of(a)
            s.contains(b) == a.contains(b)
        }
    }

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

    "intersets" {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            !s1.intersects(s2) == a.intersect(b).isEmpty()
        }
    }

    "xor" {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            s1.xor(s2) == (a.subtract(b)).union(b.subtract(a))
        }
    }

    "subsetOf" {
        forAll<Set<Int>, Set<Int>> { a, b ->
            val s1 = ArraySet.of(a)
            val s2 = ArraySet.of(b)
            (s1.subsetOf(s2)) == (a.intersect(b) == a)
        }
    }

    "plus" {
        forAll<Set<Int>, Int> { a, b ->
            val s = ArraySet.of(a)
            s + b == a + b
        }
    }

    "minus" {
        forAll<Set<Int>, Int> { a, b ->
            val s = ArraySet.of(a)
            s - b == a - b
        }
    }
})