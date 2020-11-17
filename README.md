# arrayset

A port of the array based set from [abc](https://github.com/rklaehn/abc) to Kotlin.

## Motivation

The main goal for this port was to play with the [JMH gradle plugin](https://github.com/melix/jmh-gradle-plugin) and to learn how to implement custom Kotlin collections.
Thus, the code is mostly educational.

This [blog post](http://rklaehn.github.io/2015/12/18/array-based-immutable-collections/) explains the motivation and performance characteristics of the original Scala array based collections.

## Benchmarks

The benchmarks compare creation, membership test, and bulk operations for ArraySet, kotlin.collection.HashSet and java.util.TreeSet.

### Building

TODO

### Set/element operations

The essential operations are membership tests: is the given element contained / not contained in the set?

![Membership tests](/jmh/setelement.png)

The performance of the ArraySet is comparable to java.util.TreeSet. This makes sence because lookup for contains is done using a binary search and is therefore O(log n).
Finding an element in a tree set is also O(log n). Unsurprisingly, membership tests of a hash set is much faster. If hash code collisions are rare, the performance of HashSet.contains is O(1).
