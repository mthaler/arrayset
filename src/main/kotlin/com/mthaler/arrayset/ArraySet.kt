package com.mthaler.arrayset

open class ArraySet<E : Comparable<E>>(a: Array<E>) : AbstractArraySet<E>(a) {

    fun union(that: AbstractArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.union(this.elements, that.elements))

    fun intersect(that: AbstractArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.intersection(this.elements, that.elements))

    fun subsetOf(that: AbstractArraySet<E>): Boolean =
        SetUtils.subsetOf(this.elements, that.elements)

    fun intersects(that: AbstractArraySet<E>): Boolean =
        SetUtils.intersects(this.elements, that.elements)

    fun diff(that: AbstractArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.diff(this.elements, that.elements))

    fun xor(that: AbstractArraySet<E>): ArraySet<E> =
        ArraySet(SetUtils.xor(this.elements, that.elements))

    operator fun plus(elem: E): ArraySet<E> {
        return union(singleton0(elem, elements))
    }

    operator fun minus(elem: E): ArraySet<E> {
        return diff(singleton0(elem, elements))
    }

    companion object {
        fun <T : Comparable<T>> of(vararg elements: T): Set<T> = if (elements.size > 0) {
            ArraySet(elements as Array<T>)
        } else {
            TODO()
        }

        fun <T : Comparable<T>>singleton0(e: T, a: Array<T>): ArraySet<T> =
            ArraySet(ArrayUtils.singleton(e, a))
    }
}