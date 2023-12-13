package leetcodeBlind75.linkedlist


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    var li = ListNode(5)
    li.next = ListNode(4).apply {
        next = ListNode(3).apply {
            next = ListNode(2).apply {
                next = ListNode(1).apply {
                }
            }
        }
    }

    //println(printLinkList(li))
    println( printLinkList(reverseList(li)))
}

fun printLinkList(node: ListNode?): String {
    return if (node?.next != null) {
        "${node.`val`} -> ${printLinkList(node.next)}"
    } else {
        "${node?.`val`}"
    }
}

fun reverseList(head: ListNode?): ListNode? {
    var temp = head
    var pre: ListNode? = null
    while (temp?.next != null) {
        temp = temp.next
    }
    var newHead = temp
    var tail = head
    var next = tail?.next
    while(tail!=null){
        tail.next =pre
        pre = tail
        tail = next
        next=tail?.next
    }

    return newHead
}

