package treepractice

import queuepractice.ArrayListQueue

fun <T> TreeNode<T>.printLevelInSeparateLine(){
   val queue = ArrayListQueue<TreeNode<T>>()
    var countOfChildOnCurrentLevel = 0
    queue.enqueue(this)
    while (queue.isEmpty.not()){
        countOfChildOnCurrentLevel = queue.count
        while (countOfChildOnCurrentLevel>0){
            val node = queue.dequeue()
            node?.let {
                print("${node.value} \t")
                node.children.forEach {
                    queue.enqueue(it)
                }
                countOfChildOnCurrentLevel--
            }
        }
        println()
    }
}

fun main(){
    val node15 = TreeNode(15)
    val node1 = TreeNode(1)
    val node17 = TreeNode(17)
    val node20 = TreeNode(20)
    node1.add(TreeNode(1))
    node1.add(TreeNode(5))
    node1.add(TreeNode(0))
    node17.add(TreeNode(2))
    node20.add(TreeNode(5))
    node20.add(TreeNode(7))
    node15.add(node1)
    node15.add(node17)
    node15.add(node20)

    node15.printLevelInSeparateLine()
}
