package treepractice

import queuepractice.ArrayListQueue

class TreeNode<T>(val value:T){
    internal val children = mutableListOf<TreeNode<T>>()

    fun add(child: TreeNode<T>){
        children.add(child)
    }

    fun forEachDepthFirst(visit : Visitor<T>){
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun search(value: T):TreeNode<T>?{
        var result :TreeNode<T>?=null
        forEachLevelOrder {
            if(it.value==value){
                result =it
            }
        }
        return result
    }

    fun forEachLevelOrder(visit: Visitor<T>){
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach{
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node!=null){
            visit(node)
            node.children.forEach{
                queue.enqueue(it)
            }
            node=queue.dequeue()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit

fun main(){
    val tree = makeBeverageTree()
    /*tree.forEachDepthFirst {
        println(it.value)
    }*/
    /*tree.forEachLevelOrder{
        println(it.value)
    }*/

    tree.search("ginger ale")?.let {
        println("Found node: ${it.value}")
    }
    tree.search("WKD Blue")?.let {
        println(it.value)
    } ?: println("Couldn't find WKD Blue")
}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
}