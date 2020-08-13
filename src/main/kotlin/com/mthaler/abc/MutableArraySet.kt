package com.mthaler.abc

import kotlin.collections.MutableSet

class MutableArraySet<E : Comparable<E>>(a: Array<E>) : ArraySet<E>(a), MutableSet<E> {

    override fun add(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
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
}