package com.mthaler.arrayset.primitives

import com.mthaler.arrayset.ArraySet

open class IntArraySet(a: IntArray) : AbstractSet<Int>() {

    protected val elements: IntArray

    init {
        elements = IntArrayUtils.sortAndRemoveDuplicatesInPlace(a)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: Int): Boolean {
        return IntSearching.search(elements, 0, elements.size, element) >= 0
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<Int> {
        return elements.iterator()
    }

    fun union(that: IntArraySet): IntArraySet =
        IntArraySet(IntSetUtils.union(this.elements, that.elements))

    fun intersect(that: IntArraySet): IntArraySet =
        IntArraySet(IntSetUtils.intersection(this.elements, that.elements))

    fun subsetOf(that: IntArraySet): Boolean =
        IntSetUtils.subsetOf(this.elements, that.elements)

    fun intersects(that: IntArraySet): Boolean =
        IntSetUtils.intersects(this.elements, that.elements)

    fun diff(that: IntArraySet): IntArraySet =
        IntArraySet(IntSetUtils.diff(this.elements, that.elements))

    fun xor(that: IntArraySet): IntArraySet =
        IntArraySet(IntSetUtils.xor(this.elements, that.elements))
    
    companion object {
        fun of(vararg elements: Int): IntArraySet = if (elements.size > 0) {
            IntArraySet(elements)
        } else {
            IntArraySet(intArrayOf())
        }

        fun of(collection: Collection<Int>): IntArraySet =
            IntArraySet(collection.toIntArray())
    }
}