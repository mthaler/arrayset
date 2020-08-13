package com.mthaler.arrayset

import kotlin.collections.AbstractSet

open class ArraySet<E : Comparable<E>>(a: Array<E>) : AbstractSet<E>() {

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
        if (other is ArraySet) {
            if (isEmpty() && other.isEmpty()) {
                return true
            }
            if (size != other.size) {
                return false
            }
            var i = 0
            while (i < this.elements.size) {
                if (other.elements[i] != this.elements[i]) {
                    return false
                }
                i++
            }
            return true
        } else {
            for (element in elements) {
                if (Searching.search(this.elements, 0, elements.size, element) < 0)
                    return false
            }
            return true
        }
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<E> {
        return elements.iterator()
    }

    fun union(that: ArraySet<E>): ArraySet<E> =
        ArraySet<E>(SetUtils.union(this.elements, that.elements))
}