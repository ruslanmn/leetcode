package binarytreerightsideview

import TreeNode

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val rightNodes = mutableListOf<Int>()
        var nodes = root?.let { mutableListOf(root) } ?: listOf()
        while (nodes.isNotEmpty()) {
            nodes.last()?.let { rightNodes.add(it.`val`) }
            nodes = nodes.flatMap {
                listOf(
                    it.left,
                    it.right
                )
            }.filterNotNull()
        }

        return rightNodes
    }
}

fun main() {
    val root = TreeNode(
        1,
        TreeNode(
            2,
            null,
            TreeNode(5, null, null)
        ),
        TreeNode(
            3,
            TreeNode(4, null, null),
            null
        ),
    )
    println(Solution().rightSideView(root))
}