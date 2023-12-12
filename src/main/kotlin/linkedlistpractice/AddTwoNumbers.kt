package linkedlistpractice

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var firstListPointer = l1
    var secondListPointer = l2
    var resultNode: ListNode? = null
    var tempNode: ListNode? = null
    var carry = 0
    while (firstListPointer != null || secondListPointer != null) {
        var result = (firstListPointer?.`val` ?: 0) + (secondListPointer?.`val` ?: 0) + carry
        carry = 0
        if (result >= 10) {
            carry = result / 10
            result %= 10
        }
        if (resultNode == null) {
            resultNode = ListNode(result)
            tempNode = resultNode
        } else {
            tempNode?.next = ListNode(result)
            tempNode = tempNode?.next
        }

        firstListPointer=firstListPointer?.next
        secondListPointer=secondListPointer?.next
    }

    if(carry>0){
        tempNode?.next = ListNode(carry)
    }
    return resultNode
}