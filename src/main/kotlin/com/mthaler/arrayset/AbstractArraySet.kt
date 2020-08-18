package com.mthaler.arrayset

abstract class AbstractArraySet<E : Comparable<E>>(a: Array<E>) : AbstractSet<E>() {

    protected val elements: Array<E>

    init {
        elements = ArrayUtils.sortAndRemoveDuplicatesInPlace(a)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: E): Boolean {
        return Searching.search(elements, 0, elements.size, element) >= 0
    }

    override fun containsAll(other: Collection<E>): Boolean {
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