package queuepractice

import stackppractice.StackImpl

interface Queue<T> {
    val count: Int
    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
    fun enqueue(item: T)
    fun dequeue(): T?
}

class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()
    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else list.removeAt(0)
    }

    override fun enqueue(item: T) {
        list.add(item)
    }

    override fun toString(): String {
        return list.toString()
    }
}

/*class LinkedListQueue<T>:Queue<T>{
    val list = DoublyLinkedList<T>()

    override val count: Int
        get() = TODO("Not yet implemented")

    override fun peek(): T? {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }

    override fun enqueue(item: T) {
        TODO("Not yet implemented")
    }

}*/

class StackQueue<T>:Queue<T>{
    private val leftStack = StackImpl<T>()
    private val rightStack = StackImpl<T>()

    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }

    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    override val count: Int
        get() = 0

    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()

    }

    override fun dequeue(): T? {
        if (leftStack.isEmpty) { // 1
            transferElements() // 2
        }
        return leftStack.pop()
    }

    override fun enqueue(item: T) {
        rightStack.push(item)
    }

}

fun main() {
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
}