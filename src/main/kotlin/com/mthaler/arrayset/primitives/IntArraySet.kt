package com.mthaler.arrayset.primitives

open class IntArraySet(a: IntArray) : AbstractSet<Int>() {

    protected val elements: IntArray

    init {
        elements = IntArrayUtils.sortAndRemoveDuplicatesInPlace(a)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: Int): Boolean {
        //return Searching.search(elements, 0, elements.size, element) >= 0
        TODO()
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<Int> {
        return elements.iterator()
    }

    fun union(that: IntArray): IntArraySet = TODO()

    fun intersection(that: IntArraySet): IntArraySet = TODO()

    companion object {
        fun <T : Comparable<T>> of(vararg elements: Int): IntArraySet = if (elements.size > 0) {
             IntArraySet(elements)
        } else {
            TODO()
        }
    }
}