package linkedlistpractice

fun main(){
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1).push(0)
    //list.printInReverse()
    println("beforeReverse :$list")
    list.reverseTheList()
    println("afterReverse :$list")
}

fun <T> LinkedList<T>.printInReverse(){
    this.nodeAt(0)?.printInReverse()
}

fun <T> Node<T>.printInReverse(){
    this.next?.printInReverse()
    if(this.next!=null){
        print("->")
    }
    print(this.value)
}

fun <T> LinkedList<T>.reverseTheList(){
    var temp = this.head
    this.head = this.tail
    this.tail = temp
    var next = temp
    var before : Node<T> ? = null
    while(temp !=null){
        next = next?.next
        temp.next = before
        before = temp
        temp = next
    }
}


