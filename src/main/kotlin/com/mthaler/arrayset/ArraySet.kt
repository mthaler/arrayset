package com.mthaler.arrayset

import java.util.*
import kotlin.collections.AbstractSet

open class ArraySet<E : Comparable<E>>(a: Array<E>) : AbstractSet<E>() {

    protected var elements: Array<E>

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

    infix fun union(that: ArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.union(this.elements, that.elements))

    infix fun intersect(that: ArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.intersection(this.elements, that.elements))

    infix fun subsetOf(that: ArraySet<E>): Boolean =
        SetUtils.subsetOf(this.elements, that.elements)

    infix fun intersects(that: ArraySet<E>): Boolean =
        SetUtils.intersects(this.elements, that.elements)

    infix fun diff(that: ArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.diff(this.elements, that.elements))

    infix fun xor(that: ArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.xor(this.elements, that.elements))

    operator fun plus(elem: E): ArraySet<E> {
        return union(singleton0(elem, elements))
    }

    operator fun minus(elem: E): ArraySet<E> {
        return diff(singleton0(elem, elements))
    }

    override fun toString(): String {
        return Arrays.toString(elements)
    }

    companion object {
        inline fun <reified T : Comparable<T>> of(vararg elements: T): ArraySet<T> = if (elements.size > 0) {
            ArraySet(elements as Array<T>)
        } else {
            ArraySet(emptyArray<T>())
        }

        inline fun <reified T : Comparable<T>> of(collection: Collection<T>): ArraySet<T> =
            ArraySet(collection.toTypedArray())

        fun <T : Comparable<T>>singleton0(e: T, a: Array<T>): ArraySet<T> =
            ArraySet(ArrayUtils.singleton(e, a))
    }
}