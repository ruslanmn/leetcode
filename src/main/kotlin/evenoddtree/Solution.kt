package evenoddtree

import TreeNode
import kotlin.math.max



class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        return root?.let {
            var nodes = listOf(it)
            var i = 0

            while (nodes.isNotEmpty()) {
                val values = nodes.map { it.`val` }
                val anyNotMatchingIndex = values.any { (i % 2 == 0) == (it % 2 == 0) }
                val anyWrongOrder = values
                    .zipWithNext()
                    .any() { (val1, val2) ->
                        if (i % 2 == 0)
                            val1 >= val2
                        else
                            val1 <= val2
                    }

                if (anyNotMatchingIndex || anyWrongOrder) {
                    return false
                }
                nodes = nodes.flatMap {
                    listOf(it.left, it.right)
                }
                    .filterNotNull()

                i++
            }

            return true
        } ?: true
    }
}


fun main() {
    val input = TreeNode(
        1,
        TreeNode(
            10,
            TreeNode(
                3,
                TreeNode(12, null, null),
                TreeNode(8, null, null)
            ),
            null
        ),
        TreeNode(
            4,
            TreeNode(
                7,
                TreeNode(6, null, null),
               null
            ),
            TreeNode(
                9,
                null,
                TreeNode(2, null, null)
            ),
        ),
    )
    println(Solution().isEvenOddTree(input))
}