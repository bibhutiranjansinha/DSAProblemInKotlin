package misc

import linkedlistpractice.Node


class HashMapNode(var key:Int?=null ,var value:Int?=null){
    var next : HashMapNode? =null
}

class CustomHashMap {
    private val map = (0..999).map { HashMapNode(value = 0)}.toMutableList()

    private fun hash(key:Int):Int{
        return key % map.size
    }

    private fun hashPointer(key: Int):HashMapNode{
        return map[hash(key)]
    }

    fun put(key:Int, value:Int){
        var current:HashMapNode? = hashPointer(key)
        while (current?.next!=null){
            if(current.next?.key == key){
                current.next?.value = value
                return
            }
            current = current.next
        }
        current?.next =  HashMapNode(key,value)
    }

    fun get(key: Int):Int?{
        var current:HashMapNode? = hashPointer(key)
        while (current?.next!=null){
            if(current.next?.key == key){
                return current.next?.value
            }
            current = current.next
        }
        return null
    }

    fun remove(key: Int):Int?{
        var current:HashMapNode? = hashPointer(key)
        while (current?.next!=null){
            if(current.next?.key == key){
                val value = current.next?.value
                current.next = current.next?.next
                return value
            }
            current = current.next
        }
        return null
    }

}


fun main(){
    val map = CustomHashMap().apply {
        put(3,5)
        put(4,9)
        put(4,9)
        put(0,4)
        put(1000,5)
    }
    println(map.get(0))
    println(map.get(1000))
    map.remove(0)
    println(map.get(1000))
    map.remove(1000)
    println(map.get(1000))
}