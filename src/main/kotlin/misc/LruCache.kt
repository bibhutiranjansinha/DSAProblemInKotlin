package misc

class LruCache<K, V>(private val capacity: Int) {
    class Node<K, V>(val key: K, var value: V) {
        var next: Node<K, V>? = null
        var previous: Node<K, V>? = null
        override fun toString(): String {
            return if (this.next != null) {
                "($key, $value) -> ${this.next.toString()}"
            } else {
                "($key, $value)"
            }
        }
    }

    private val cache = HashMap<K, Node<K, V>>(capacity)
    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null

    fun put(key: K, value: V) {
        if(cache.containsKey(key)){
            val node = cache[key]!!
            node.value = value
            moveToFront(node)
            return
        }

        if(cache.size == capacity){
            cache.remove(tail?.key)
            removeNode(tail!!)
        }

        val node = Node(key,value)
        cache.put(key,node)
        addFirst(node)
    }

    fun get(key: K):V?{
        if(cache.containsKey(key)){
            val node = cache[key]!!
            moveToFront(node)
            return node.value
        }
        return null
    }

    fun remove(key: K){
        val node = cache[key]
        node?.let {
            cache.remove(it.key)
            removeNode(it)
        }
    }

    override fun toString(): String {
        return head?.toString() ?: "Lru is Empty"
    }

    private fun removeNode(node: Node<K, V>) {
        val prevNode = node.previous
        val nextNode = node.next

        if (prevNode != null)
            prevNode.next = nextNode
        else
            head = nextNode

        if (nextNode != null)
            nextNode.previous = prevNode
        else
            tail = prevNode
    }

    private fun addFirst(node: Node<K, V>) {
        node.next = head
        head?.previous = node
        head = node
        head?.previous = null
        if (tail == null) tail = node
    }

    private fun moveToFront(node: Node<K, V>) {
        removeNode(node)
        addFirst(node)
    }
}

fun main(){
    val cache = LruCache<Int, Int>(3)

    cache.put(1, 100)
    cache.put(2, 200)
    cache.put(3, 300)
    println(cache.toString())      //prints  3 : 300     2 : 200    1 : 100
    cache.put(4, 400)
    println(cache.toString())     //prints  4 : 400    3 : 300    2 : 200
    println(cache.get(3)) //prints 300
    println(cache.toString())     //prints  3 : 300    4 : 400     2 : 200
}