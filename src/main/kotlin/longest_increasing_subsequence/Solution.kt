package longest_increasing_subsequence


class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val b = IntArray(nums.size) { 0 }
        nums.indices.forEach { i ->
            val leaves = (0 until i)
                .filter { nums[it] < nums[i] }
            b[i] = 1 + if (leaves.isNotEmpty()) leaves.maxOf { b[it] } else 0
        }

        return b.max()
    }
}


fun main() {
    val input = intArrayOf(10,9,2,5,3,7,101,18)
    println(Solution().lengthOfLIS(input))
}