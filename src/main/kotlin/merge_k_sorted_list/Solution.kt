package merge_k_sorted_list


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

data class ListNode (
    val `val`: Int,
    var next: ListNode?
) {

    fun `toList()`(): List<Int> {
        val values = ArrayList<Int>()
        var node:ListNode? = this
        while (node != null) {
            node.let {
                values.add(it.`val`)
                node = it.next
            }
        }

        return values
    }

    companion object {
        fun from(arr: IntArray): ListNode? {
            return arr.reversed().fold<Int, ListNode?>(null) { acc, value ->
                ListNode(value, acc)
            }
        }
    }
}

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var descSorted: ListNode? = null

        var minInd = next(lists)
        while (minInd >= 0) {
            lists[minInd]?.also {
                descSorted = ListNode(it.`val`, descSorted)
                lists[minInd] = it.next
            }
            minInd = next(lists)
        }

        var ascSorted: ListNode? = null
        while (descSorted != null) {
            descSorted?.let {
                ascSorted = ListNode(it.`val`, ascSorted)
                descSorted = it.next
            }

        }

        return ascSorted
    }

    fun next(lists: Array<ListNode?>): Int {
        return lists.withIndex()
            .filter { it.value != null }
            .minByOrNull { it.value!!.`val`  }?.index ?: -1
    }
}

fun main() {
    val lists = arrayOf(
        ListNode.from(intArrayOf(1,4,5)),
        ListNode.from(intArrayOf(1,3,4)),
        ListNode.from(intArrayOf(2,6))
    )

    println(Solution().mergeKLists(lists)?.`toList()`())
}