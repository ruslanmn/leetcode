package robber

import kotlin.math.max

class Solution2 {
    fun rob(nums: IntArray): Int {
        return if (nums.size > 1)
            Math.max(
                robSeq(nums.dropLast(1)),
                robSeq(nums.drop(1))
            )
        else
            nums.first()
    }

    fun robSeq(nums: List<Int>): Int {
        return nums.fold(0 to 0) { acc, house ->
            acc.second to Math.max(acc.first + house, acc.second)
        }.second
    }
}


fun main() {
    val input = intArrayOf(1,2,3,1)
    val output = 4
    println(Solution2().rob(input))
}