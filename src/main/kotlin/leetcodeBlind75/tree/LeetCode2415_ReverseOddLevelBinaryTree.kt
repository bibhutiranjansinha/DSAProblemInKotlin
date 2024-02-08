package leetcodeBlind75.tree

fun reverseOddLevels(root: TreeNode?): TreeNode? {
    var level = 1
    val queue = arrayListOf<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        var size = queue.size
        while (size > 0) {
            val node = queue.removeAt(0)
            if (level % 2 != 0) {
                val tmp = node?.left?.`val` ?: 0
                node?.left?.`val` = node?.right?.`val`?:0
                node?.right?.`val` = tmp
            }
            node?.left?.let {
                queue.add(node.left)
            }
            node?.right?.let {
                queue.add(node.right)
            }
            size--
        }
        level++
    }
    return root
}