package fairarray

import kotlin.math.max

class Solution {
    fun waysToMakeFair(nums: IntArray): Int {
        var sumLeft = 0
        val left = nums.mapIndexed { index, value ->
            sumLeft = sumLeft + (if (index % 2 == 0) 1 else -1) * value
            sumLeft
        }
        var sumRight = 0
        val right = nums.reversed().mapIndexed { index, value ->
            sumRight = sumRight + (if ((nums.size - index - 1) % 2 == 0) -1 else 1) * value
            sumRight
        }.reversed()

        return nums.indices.count {
            (
                (if (it > 0) left[it - 1] else 0)
                    + (if (it < nums.size - 1) right[it + 1] else 0)
            ) == 0
        }
    }
}


fun main() {
    val input = intArrayOf(2, 1, 6, 4)
    println(Solution().waysToMakeFair(input))
}