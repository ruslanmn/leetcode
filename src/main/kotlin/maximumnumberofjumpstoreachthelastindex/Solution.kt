package maximumnumberofjumpstoreachthelastindex

class Solution {
    fun maximumJumps(nums: IntArray, target: Int): Int {
        val dp = IntArray(nums.size) { 0 }

        dp.indices.forEach { i ->
            if (dp[i] > 0 || i == 0) {
                dp.indices.drop(i + 1).forEach { j ->
                    if (Math.abs(nums[j] - nums[i]) <= target) {
                        dp[j] = Math.max(dp[j], dp[i] + 1)
                    }
                }
            }
        }

        return dp.last().let {
            if (it > 0) it else -1
        }
    }
}

fun main() {
    val nums = intArrayOf(1,3,6,4,1,2)
    val target = 2
    println(Solution().maximumJumps(nums, target))
}