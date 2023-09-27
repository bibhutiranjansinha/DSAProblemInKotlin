package stackppractice

interface Stack<T>{
    fun push(element: T)
    fun pop(): T?
    fun peek():T?
}

class StackImpl<T>: Stack<T> {
    private val storage = mutableListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if(storage.size==0){
            return null
        }
        return storage.removeAt(storage.size-1)
    }

    override fun peek(): T? {
        return storage.getOrNull(0)
    }

    override fun toString()=buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    val isEmpty:Boolean
        get()= storage.size ==0
}

fun main(){
    val stack =StackImpl<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }
    print(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("Popped: $poppedElement")
    }
    print(stack)
}