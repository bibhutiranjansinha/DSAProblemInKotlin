package treepractice

import kotlin.math.max
import kotlin.math.pow

typealias avlVisitor = (value:Int?)->Unit

class AVLNode(var data:Int){
    var leftChild : AVLNode? =null
    var rightChild : AVLNode? =null

    val min:AVLNode
        get()= leftChild?.min?:this

    val max:AVLNode
        get()=rightChild?.max?:this

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1
    val rightHeight: Int
        get() = rightChild?.height ?: -1
    val balanceFactor: Int
        get() = leftHeight - rightHeight

    fun height(node:AVLNode? = this):Int{
        return node?.let {
            1+ max(height(node.leftChild),height(node.rightChild))
        }?:-1
    }

    fun inOrderTraversal(visitor: avlVisitor){
        leftChild?.inOrderTraversal(visitor)
        visitor(data)
        rightChild?.inOrderTraversal(visitor)
    }

    fun preOrderTraversal(visitor: avlVisitor){
        visitor(data)
        leftChild?.preOrderTraversal(visitor)
        rightChild?.preOrderTraversal(visitor)
    }

    fun postOrderTraversal(visitor: avlVisitor){
        leftChild?.preOrderTraversal(visitor)
        rightChild?.preOrderTraversal(visitor)
        visitor(data)
    }



}

class AVLSearchTree{
    var root:AVLNode?=null

    fun leftRotate(node:AVLNode):AVLNode?{
        val pivot = node.rightChild
        node.rightChild = pivot?.leftChild
        pivot?.leftChild =node
        node.height = max(node.leftHeight,node.rightHeight)+1
        pivot?.height = max(pivot?.leftHeight?:-1,pivot?.rightHeight?:-1)+1
        return pivot
    }

    fun rightRotate(node: AVLNode):AVLNode?{
        val pivot = node.leftChild
        node.leftChild = pivot?.rightChild
        pivot?.rightChild=node
        node.height = max(node.leftHeight,node.rightHeight)+1
        pivot?.height = max(pivot?.leftHeight?:-1,pivot?.rightHeight?:-1)+1
        return pivot
    }

    fun rightLeftRotation(node: AVLNode):AVLNode?{
        val rightChild = node.rightChild?:node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }


    fun leftRightRotation(node: AVLNode):AVLNode?{
        val leftChild = node.leftChild?:node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balance(node:AVLNode):AVLNode?{
        return when(node.balanceFactor){
            //left subtree is heavy we need to perform right rotation
            2->{
                if(node.leftChild?.balanceFactor == -1){
                    leftRightRotation(node)
                }else{
                    rightRotate(node)
                }
            }
            //right subtree is heavy we need to perform left rotation
            -2->{
                if(node.rightChild?.balanceFactor == -1){
                    rightLeftRotation(node)
                }else{
                    leftRotate(node)
                }
            }
            else -> node
        }
    }

    fun insert(value:Int){
        root = insert(root,value)
    }

    fun remove(value: Int){
        root = insert(root,value)
    }

    private fun remove(node:AVLNode? ,value: Int):AVLNode?{
        node?:return null
        when{
            node.data == value ->{
                if(node.leftChild==null && node.rightChild==null){
                    return null
                }
                if(node.leftChild==null){
                    return node.rightChild
                }
                if(node.rightChild==null){
                    return node.leftChild
                }
                node.rightChild?.min?.data?.let {
                    node.data =it
                }
                node.rightChild =remove(node.rightChild,node.data)
            }
            value<node.data ->{
                node.leftChild = remove(node.leftChild,value)
            }
            else ->{
                node.rightChild =remove(node.rightChild,value)
            }
        }

        val balancedNode = balance(node)
        balancedNode?.height= max(balancedNode?.leftChild?.height?:0,balancedNode?.rightChild?.height?:0)
        return balancedNode
    }

    private fun insert(node:AVLNode? ,value: Int):AVLNode?{
        node?:return AVLNode(value)
        if(value>=node.data){
            node.rightChild = insert(node.rightChild,value)
        }else{
            node.leftChild = insert(node.leftChild,value)
        }

        val balancedNode = balance(node)
        balancedNode?.height= max(balancedNode?.leftChild?.height?:0,balancedNode?.rightChild?.height?:0)
        return balancedNode
    }

    fun numberOfleafNodes(height: Int): Int {
        return 2.0.pow(height).toInt()
    }

    fun nodes(height: Int): Int {
        var totalNodes = 0
        (0..height).forEach { currentHeight ->
            totalNodes += 2.0.pow(currentHeight).toInt()
        }
        return totalNodes
    }

    fun printLeftViewOfTree(){

    }


}