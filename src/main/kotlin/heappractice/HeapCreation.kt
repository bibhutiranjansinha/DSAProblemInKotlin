package heappractice

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

interface Collection<Element> {
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun insert(element: Element)
    fun remove(): Element?
    fun remove(index: Int): Element?
}

interface Heap<Element> : Collection<Element> {
    fun peek(): Element?
}

abstract class AbstractHeap<Element>() : Heap<Element> {
    var elements: ArrayList<Element> = ArrayList<Element>()
    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.first()

    override fun insert(element: Element) {
        elements.add(element)
        shiftUp(count - 1)
    }

    override fun remove(): Element? {
        if (isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item
    }

    override fun remove(index: Int): Element? {
        if (index >= count) return null // 1
        return if (index == count - 1) {
            elements.removeAt(count - 1) // 2
        } else {
            Collections.swap(elements, index, count - 1) // 3
            val item = elements.removeAt(count - 1) // 4
            siftDown(index) // 5
            shiftUp(index)
            item
        }
    }

    abstract fun compare(a: Element, b: Element): Int

    private fun leftChildIndex(index: Int) = (2 * index) + 1
    private fun rightChildIndex(index: Int) = (2 * index) + 2
    private fun parentIndex(index: Int) = (index - 1) / 2

    private fun siftDown(index: Int) {
        //Initial Parent Index
        var parentIndex = index
        while (true) {
            // finding left and right child index
            val leftChildIndex = leftChildIndex(parentIndex)
            val rightChildIndex = rightChildIndex(parentIndex)
            //Let's find the candidate index
            var candidate = parentIndex
            if (leftChildIndex < count && compare(elements[leftChildIndex], elements[candidate]) > 0) {
                candidate = leftChildIndex
            }
            if (rightChildIndex < count && compare(elements[rightChildIndex], elements[candidate]) > 0) {
                candidate = rightChildIndex
            }

            // after finding candidate we are checking if  where we reached the destination
            if (candidate == parentIndex)
                return
            Collections.swap(elements, candidate, parentIndex)
            parentIndex = candidate
        }
    }

    private fun shiftUp(index: Int) {
        var child = index
        var parentOfChild = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parentOfChild])
            > 0
        ) {
            Collections.swap(elements, child, parentOfChild)
            child = parentOfChild
            parentOfChild = parentIndex(child)
        }
    }

    protected fun heapify(values: ArrayList<Element>) {
        elements = values
        if (elements.isNotEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }
}

class ComparableHeapImpl<Element : Comparable<Element>>() :
    AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int =
        a.compareTo(b)

    companion object {
        fun <Element : Comparable<Element>> create(
            elements: ArrayList<Element>
        ): Heap<Element> {
            val heap = ComparableHeapImpl<Element>()
            heap.heapify(elements)
            return heap
        }
    }
}

class ComparatorHeapImpl<Element>(
    private val comparator: Comparator<Element>
) : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int =
        comparator.compare(a, b)

    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}

fun main() {
    /* val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
     val priorityQueue = ComparableHeapImpl.create(array) // 2
     while (!priorityQueue.isEmpty) { // 3
         println(priorityQueue.remove())
     }*/

    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7) // 1
    val inverseComparator = object : Comparator<Int> { // 2
        override fun compare(o1: Int, o2: Int): Int =
            o2.compareTo(o1)
    }
    val minHeap = ComparatorHeapImpl.create(
        array,
        inverseComparator
    ) // 3
    while (!minHeap.isEmpty) { // 4
        println(minHeap.remove())
    }
}