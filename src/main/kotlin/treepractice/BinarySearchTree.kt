package treepractice

class BinarySearchTree<T:Comparable<T>>{
    private var root :BinaryNode<T>?=null

    fun insert(value: T){
       root = insert(root,value)
    }

    fun remove(value: T){
        root =remove(root,value)
    }

    private fun remove(node:BinaryNode<T>?,value: T):BinaryNode<T>?{
        node?:return null
        when {
            value == node.value ->{
                // if the node was leaf node
                if(node.leftChild == null && node.rightChild ==null){
                    return null
                }
                // if node is not leaf node and it has only right child
                if(node.leftChild == null){
                    return node.rightChild
                }

                // if node is not leaf node and it has only left child
                if(node.rightChild == null){
                    return node.leftChild
                }

                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = remove(node.rightChild,node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild,value)
            else -> node.rightChild = remove(node.rightChild,value)
        }
        return node
    }

    private fun insert(node:BinaryNode<T>?, value: T):BinaryNode<T>{
        node?: return BinaryNode(value)
        if(value<node.value){
            node.leftChild = insert(node.leftChild,value)
        }else{
            node.rightChild = insert(node.rightChild,value)
        }
        return node
    }

    override fun toString(): String {
       return root?.toString()?:"Empty Tree"
    }

    fun contains(value: T):Boolean{
        root?:return false
        var found = false
        root?.inOrderTraverse {
            if(it == value)
                found=true
        }
        return found
    }

    fun optimisedContains(value: T):Boolean{
        root?:return false
        var current = root
        while (current!=null){
            if(current.value == value){
                return true
            }
            current = if(value<current.value){
                current.leftChild
            }else{
                current.rightChild
            }
        }
        return false
    }
}

fun main(){
/*    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }*/
    //println(exampleTree.optimisedContains(5))
    //println

    println("Tree before removal:")
    println(exampleTree)
    exampleTree.remove(5)
    println("Tree after removing root:")
    println(exampleTree)
}

val exampleTree = BinarySearchTree<Int>().apply {
    insert(3)
    insert(1)
    insert(4)
    insert(0)
    insert(2)
    insert(5)
}

