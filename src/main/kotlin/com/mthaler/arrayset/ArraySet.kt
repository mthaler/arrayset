package com.mthaler.arrayset

import kotlin.collections.AbstractSet

class ArraySet<E : Comparable<E>>(a: Array<E>) : AbstractSet<E>() {

    val elements: Array<E>

    init {
        elements = ArrayUtils.sortAndRemoveDuplicatesInPlace(a)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: E): Boolean {
        return Searching.search(elements, 0, elements.size, element) >= 0
    }

    // todo: optimize
    override fun containsAll(elements: Collection<E>): Boolean {
        for (element in elements) {
            if (Searching.search(this.elements, 0, elements.size, element) < 0)
                return false
        }
        return true
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<E> {
        return elements.iterator()
    }
}