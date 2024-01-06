package robber

import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        return nums.fold(Pair(0, 0)) { acc, house ->
            Pair(
                acc.second,
                Math.max(acc.first + house, acc.second)
            )
        }.second
    }
}


fun main() {
    val input = intArrayOf(1,2,3,1)
    val output = 4
    println(Solution().rob(input))
}