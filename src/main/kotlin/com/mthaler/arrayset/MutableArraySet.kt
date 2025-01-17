package com.mthaler.arrayset

import kotlin.collections.MutableSet

class MutableArraySet<E : Comparable<E>>(a: Array<E>) : ArraySet<E>(a), MutableSet<E> {

    override fun add(element: E): Boolean {
        val oldSize = this.elements.size
        this.elements = SetUtils.union(this.elements, ArrayUtils.singleton(element, elements))
        return oldSize != this.elements.size
    }

    override fun addAll(elements: Collection<E>): Boolean {
        if (elements.isEmpty()) {
            return false
        } else {
            val oldSize = this.elements.size
            val a = ArrayUtils.sortAndRemoveDuplicatesInPlace(ArrayUtils.toArray(elements))
            this.elements = SetUtils.union(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    override fun clear() {
        this.elements = ArrayUtils.newArray(0, this.elements)
    }

    override fun iterator(): MutableIterator<E> {
        TODO("Not yet implemented")
    }

    override fun remove(element: E): Boolean {
        val oldSize = this.elements.size
        this.elements = SetUtils.diff(this.elements, ArrayUtils.singleton(element, elements))
        return oldSize != this.elements.size
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        if (elements.isEmpty()) {
            return false
        } else {
            val oldSize = this.elements.size
            val a = ArrayUtils.sortAndRemoveDuplicatesInPlace(ArrayUtils.toArray(elements))
            this.elements = SetUtils.diff(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        if (elements.isEmpty()) {
            val oldSize = this.elements.size
            clear()
            return oldSize != this.elements.size
        } else {
            val oldSize = this.elements.size
            val a = ArrayUtils.sortAndRemoveDuplicatesInPlace(ArrayUtils.toArray(elements))
            this.elements = SetUtils.intersection(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    companion object {
        inline fun <reified T : Comparable<T>> of(vararg elements: T): MutableArraySet<T> = if (elements.size > 0) {
            MutableArraySet(elements as Array<T>)
        } else {
            MutableArraySet(emptyArray<T>())
        }

        inline fun <reified T : Comparable<T>> of(collection: Collection<T>): MutableArraySet<T> =
            MutableArraySet(collection.toTypedArray())
    }
}