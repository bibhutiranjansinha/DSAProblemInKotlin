package leetcodeBlind75.tree

import queuepractice.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


/**
 * Recursive Solutions
 */
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    var temp = root.left
    root.left = root.right
    root.right = temp
    invertTree(root.left)
    invertTree(root.right)
    return root
}

/**
 * Recursive Solutions
 */
fun invertTreeIterative(root: TreeNode?): TreeNode? {
    val queue = arrayListOf<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()){
        var size = queue.size
        while (size>0){
            val node = queue.removeAt(0)
            var tmp  = node?.left
            node?.left =node?.right
            node?.right = tmp
            node?.left?.let {
                queue.add(node.left)
            }
            node?.right?.let {
                queue.add(node.right)
            }
            size--
        }
    }
    return root
}