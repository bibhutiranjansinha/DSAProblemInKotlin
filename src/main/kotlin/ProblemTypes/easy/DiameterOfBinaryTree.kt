package ProblemTypes.easy

import leetcodeBlind75.tree.TreeNode
import java.util.Stack


/**
 * Not completed
 */
fun diameterOfBinaryTree(root: TreeNode?): Int {
    val depthMap = mutableMapOf<TreeNode, Int>()
    val traversalStack = Stack<TreeNode>()
    if (root != null) {
        traversalStack.push(root)
    }

    var diameter = 0

    while (traversalStack.isNotEmpty()) {
        val node = traversalStack.peek()
        var leftDepth = 0
        var rightDepth = 0
        node.left?.let {
            //if (!depthMap.containsKey(it)) {
            traversalStack.push(it)
            //}
            leftDepth = depthMap.getOrDefault(node.left, 0)
        }
        node.right?.let {
            //if (!depthMap.containsKey(it)) {
            traversalStack.push(it)
            //}
            rightDepth = depthMap.getOrDefault(node.right, 0)
        }

        depthMap[node] = 1 + Math.max(leftDepth, rightDepth)

        diameter = Math.max(diameter, leftDepth + rightDepth)
    }

    return diameter
}

fun main(){
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    println(diameterOfBinaryTree(root))
}