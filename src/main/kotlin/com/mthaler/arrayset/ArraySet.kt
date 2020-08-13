package com.mthaler.arrayset

abstract class ArraySet<E : Comparable<E>>(val elements: Array<E>) : Set<E> {
    override val size: Int
        get() = TODO("Not yet implemented")

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