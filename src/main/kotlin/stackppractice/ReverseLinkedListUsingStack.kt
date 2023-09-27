package stackppractice

import linkedlistpractice.LinkedList

fun <T> LinkedList<T>.printReverseLinkedListUsingStack(){
    var currentNode = this.head
    val stack = StackImpl<T>()
    while (currentNode!=null){
        stack.push(currentNode.value)
        currentNode= currentNode.next
    }
    var node = stack.pop()
    while (node!=null){
        print(node)
        node=stack.pop()
    }
}

fun main(){
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3).push(4).push(5)
    list.printReverseLinkedListUsingStack()
}