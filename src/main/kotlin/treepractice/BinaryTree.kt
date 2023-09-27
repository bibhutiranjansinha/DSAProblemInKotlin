package treepractice

import kotlin.math.max

typealias btVisitor<T> = (T?) -> Unit

class BinaryNode<T>(var value: T) : Comparable<T> {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null


    /**
     * Recursive Property
     */
    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    val max: BinaryNode<T>
        get() = rightChild?.max ?: this

    /* val isBinarySearchTree:Boolean
         get() = isBST(this,null,null)*/


/*
    private fun isBST(node: BinaryNode<T>?, min: T?, max: T?): Boolean {
        node ?: return true
        if (min != null && node.value <= min) {
            return false
        }
        if (max != null && node > max) {
            return false
        }

        return isBST(node.leftChild, min, node.value) && isBST(node.rightChild, node.value, max)
    }
*/

    fun inOrderTraverse(btVisit: btVisitor<T>) {
        leftChild?.inOrderTraverse(btVisit)
        btVisit(this.value)
        rightChild?.inOrderTraverse(btVisit)
    }

    fun preOrderTraverse(btVisit: btVisitor<T>) {
        btVisit(this.value)
        leftChild?.preOrderTraverse(btVisit)
        rightChild?.preOrderTraverse(btVisit)
    }

    fun postOrderTraverse(btVisit: btVisitor<T>) {
        leftChild?.postOrderTraverse(btVisit)
        rightChild?.postOrderTraverse(btVisit)
        btVisit(this.value)
    }

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let {
            1 + max(height(node.leftChild), height(node.rightChild))
        } ?: -1
    }

    fun preOrderTraversewithNull(btVisit: btVisitor<T>) {
        btVisit(this.value)
        leftChild?.preOrderTraverse(btVisit) ?: btVisit(null)
        rightChild?.preOrderTraverse(btVisit) ?: btVisit(null)
    }

    fun serialize(node: BinaryNode<T>? = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        this.preOrderTraversewithNull {
            list.add(it)
        }
        return list
    }

    fun deserialize(list: MutableList<T?>): BinaryNode<T?> {
        val rootValue = list.removeAt(list.size - 1)
        val rootNode = BinaryNode(rootValue)
        rootNode.leftChild = deserialize(list)
        rootNode.rightChild = deserialize(list)
        return rootNode
    }

    override fun compareTo(other: T): Int {
        return this.compareTo(other)
    }

    override fun toString() = diagram(this)
    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }
}

fun <T> BinaryNode<T>.printLeftViewOfTree(){
    val queue = mutableListOf<BinaryNode<T>>()
    var numberOfNodesInCurrentLevel = 0
    queue.add(this)
    while (queue.isNotEmpty()){
        numberOfNodesInCurrentLevel = queue.count()
        var isVisited = false
        while (numberOfNodesInCurrentLevel>0){
            val node = queue.removeAt(0)
            if(!isVisited){
                println(node.value)
                isVisited=true
            }
            node.leftChild?.let {
                queue.add(it)
            }
            node.rightChild?.let {
                queue.add(it)
            }
            numberOfNodesInCurrentLevel--
        }
    }
}

fun <T> BinaryNode<T>.printRightViewOfTree(){
    val queue = mutableListOf<BinaryNode<T>>()
    var numberOfNodesInCurrentLevel = 0
    queue.add(this)
    while (queue.isNotEmpty()){
        numberOfNodesInCurrentLevel = queue.size
        while (numberOfNodesInCurrentLevel>0){
            val node = queue.removeAt(0)
            if(numberOfNodesInCurrentLevel==1){
                println(node.value)
            }
            node.leftChild?.let {
                queue.add(it)
            }
            node.rightChild?.let {
                queue.add(it)
            }
            numberOfNodesInCurrentLevel--
        }
    }
}

fun main() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree = seven
    tree.inOrderTraverse {
        println(it)
    }
    println()
    //println(tree.height())
    tree.printLeftViewOfTree()

    println()


    val map = LinkedHashMap<Int,Int>()
    map.put(1,2)
    map.put(1,3)

    map.forEach { t, u -> println("$t, $u")  }

}