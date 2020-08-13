package com.mthaler.arrayset

abstract class BinaryMerge {

    fun binarySearchB(ai: Int, b0: Int, b1: Int): Int {

        tailrec fun binarySearch0(low: Int, high: Int): Int {
            if (low <= high) {
                val mid = (low + high) ushr 1
                val c = compare(ai, mid)
                if (c > 0)
                    return binarySearch0(mid + 1, high)
                else if (c < 0)
                    return binarySearch0(low, mid - 1)
                else
                    return mid
            } else
                return -(low + 1)
        }
        return binarySearch0(b0, b1 - 1)
    }

    /**
     * Compare element ai of the first sequence with element bi of the second sequence
     * @param ai an index into the first sequence
     * @param bi an index into the second sequence
     * @return -1 if a(ai) &lt; b(bi), 0 if a(ai) == b(bi), 1 if a(ai) &gt; b(bi)
     */
    abstract fun compare(ai: Int, bi: Int): Int

    /**
     * Called when elements a(ai) and b(bi) are equal according to compare
     * @param ai
     * @param bi
     */
    abstract fun collision(ai: Int, bi: Int)

    /**
     * Called for a subsequence of elements of a that are not overlapping any element of b
     */
    abstract fun fromA(a0: Int, a1: Int, bi: Int)

    /**
     * Called for a subsequence of elements of b that are not overlapping any element of a
     */
    abstract fun fromB(ai: Int, b0: Int, b1: Int)
}