package com.mthaler.arrayset

import kotlin.collections.AbstractSet

abstract class ArraySet<E : Comparable<E>>(val elements: Array<E>) : AbstractSet<E>() {
    override val size: Int
        get() = elements.size

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
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