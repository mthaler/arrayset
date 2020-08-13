package com.mthaler.arrayset

import kotlin.collections.AbstractSet

abstract class ArraySet<E : Comparable<E>>(a: Array<E>) : AbstractSet<E>() {

    val elements: Array<E>

    init {
        elements = ArrayUtils.sortAndRemoveDuplicatesInPlace(a)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: E): Boolean {
        return Searching.search(elements, 0, elements.size, element) >= 0
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<E> {
        return elements.iterator()
    }
}