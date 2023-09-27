package linkedlistpractice

import java.lang.IndexOutOfBoundsException


fun main() {
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)
    // println(list)
    //list.append(4).append(5).append(6)
    /*println("Before inserting: $list")
    var middleNode = list.nodeAt(1)!!
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode)
    }
    println("After inserting: $list")*/
  /*  println("Before popping list: $list")
    val poppedValue = list.pop()
    println("After popping list: $list")
    println("Popped value: $poppedValue")*/
   /* println("Before removing last node: $list")
    val removedValue = list.removeLast()
    println("After removing last node: $list")
    println("Removed value: $removedValue")*/
    /*println("Before removing at particular index: $list")
    val index = 1
    val node = list.nodeAt(index - 1)!!
    val removedValue = list.removeAfter(node)
    println("After removing at index $index: $list")
    println("Removed value: $removedValue")*/
    for (item in list) {
        println("Double: ${item * 2}")
    }

}

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (this.next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T>:Iterable<T>,Collection<T>,MutableIterable<T> {
    internal var head: Node<T>? = null
    internal var tail: Node<T>? = null
    override var size = 0
        private set

    override fun containsAll(elements: Collection<T>): Boolean {
        for (toBeSearch in elements){
            if(!contains(toBeSearch)) return false
        }
        return true
    }

    override fun contains(element: T): Boolean {
        for(item in this){
            if(element == item){
                return true
            }
        }
        return false
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head?.toString() ?: "Empty List"
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currencyNode = head
        var currentIndex = 0
        while (currencyNode != null && currentIndex < index) {
            currencyNode = currencyNode.next
            currentIndex++
        }
        return currencyNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val node = Node(value, afterNode.next)
        afterNode.next = node
        size++
        return node
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val currentNode = head
        head = head?.next
        currentNode?.next =null
        if(isEmpty()){
            tail =null
        }
        return currentNode?.value
    }

    fun removeLast():T?{
        if(head==null) return null
        if(head?.next ==null) return pop()
        size--
        var currentNode = head
        while(currentNode?.next!=tail){
            currentNode=currentNode?.next
        }
        val result = tail?.value
        currentNode?.next =null
        tail = currentNode
        return result
    }

    fun removeAfter(node: Node<T>):T?{
        val nodeToRemove = node.next
        if(node.next ==tail){
            tail =node
            tail?.next =null
            return nodeToRemove?.value
        }
        node.next = nodeToRemove?.next
        nodeToRemove?.next =null
        size--
        return nodeToRemove?.value
    }
}

class LinkedListIterator<T>(
    private val list: LinkedList<T>
): Iterator<T>,MutableIterator<T>{
    private var index = 0
    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return index<list.size
    }

    override fun next(): T {
        if(index>=list.size) throw IndexOutOfBoundsException()
        lastNode = if(index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }

    override fun remove() {

    }

}