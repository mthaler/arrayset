package com.mthaler.arrayset

import kotlin.collections.MutableSet

class MutableArraySet<E : Comparable<E>>(a: Array<E>) : ArraySet<E>(a), MutableSet<E> {

    override fun add(element: E): Boolean {
        val oldSize = this.elements.size
        this.elements = SetUtils.union(this.elements, ArrayUtils.singleton(element, elements))
        return oldSize != this.elements.size
    }

    override fun addAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        this.elements = ArrayUtils.newArray(0, this.elements)
    }

    override fun iterator(): MutableIterator<E> {
        TODO("Not yet implemented")
    }

    override fun remove(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        fun <T : Comparable<T>> of(vararg elements: T): MutableArraySet<T> = if (elements.size > 0) {
            MutableArraySet(elements as Array<T>)
        } else {
            TODO()
        }
    }
}