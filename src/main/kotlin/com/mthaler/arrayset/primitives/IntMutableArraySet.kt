package com.mthaler.arrayset.primitives

class IntMutableArraySet(a: IntArray) :  IntArraySet(a), MutableSet<Int> {

    override fun add(element: Int): Boolean {
        val oldSize = this.elements.size
        this.elements = IntSetUtils.union(this.elements, IntArrayUtils.singleton(element))
        return oldSize != this.elements.size
    }

    override fun addAll(elements: Collection<Int>): Boolean {
        if (elements.isEmpty()) {
            return false
        } else {
            val oldSize = this.elements.size
            val a = IntArrayUtils.sortAndRemoveDuplicatesInPlace(elements.toIntArray())
            this.elements = IntSetUtils.union(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    override fun clear() {
        this.elements = intArrayOf()
    }

    override fun iterator(): MutableIterator<Int> {
        TODO("Not yet implemented")
    }

    override fun remove(element: Int): Boolean {
        val oldSize = this.elements.size
        this.elements = IntSetUtils.diff(this.elements, IntArrayUtils.singleton(element))
        return oldSize != this.elements.size
    }

    override fun removeAll(elements: Collection<Int>): Boolean {
        if (elements.isEmpty()) {
            return false
        } else {
            val oldSize = this.elements.size
            val a = IntArrayUtils.sortAndRemoveDuplicatesInPlace(elements.toIntArray())
            this.elements = IntSetUtils.diff(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    override fun retainAll(elements: Collection<Int>): Boolean {
        if (elements.isEmpty()) {
            val oldSize = this.elements.size
            clear()
            return oldSize != this.elements.size
        } else {
            val oldSize = this.elements.size
            val a = IntArrayUtils.sortAndRemoveDuplicatesInPlace(elements.toIntArray())
            this.elements = IntSetUtils.intersection(this.elements, a)
            return oldSize != this.elements.size
        }
    }

    companion object {
        fun of(vararg elements: Int): IntMutableArraySet = IntMutableArraySet(elements)

        fun of(collection: Collection<Int>): IntMutableArraySet = IntMutableArraySet(collection.toIntArray())
    }
}