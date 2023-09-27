package linkedlistpractice

fun main(){
    val list = LinkedList<Int>()
    list.push(4).push(3).push(2).push(1)
    println(list.findMiddle())
    list.removeLast()
    println(list.findMiddle())
}

fun <T> LinkedList<T>.findMiddle():T?{
    if(isEmpty()){
        return null
    }
    var fastRunner = head
    var slowRunner = head

    while (fastRunner != null){
        fastRunner = fastRunner.next
        if(fastRunner!=null){
            fastRunner = fastRunner.next
            slowRunner = slowRunner?.next
        }
    }
    return slowRunner?.value
}