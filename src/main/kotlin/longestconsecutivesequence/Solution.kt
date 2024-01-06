package longestconsecutivesequence

class Solution {

    data class MinAcc(
        val maxCount: Int,
        val count: Int,
        val prev: Int
    )

    fun longestConsecutive(nums: IntArray): Int {
        return nums.sorted()
            .fold(MinAcc(0, 0, 0)) { acc, value ->
                if (acc.count == 0) {
                    MinAcc(1, 1, value)
                } else if (acc.prev == value) {
                    acc
                } else {
                    MinAcc(
                        Math.max(
                            acc.maxCount,
                            if (value == acc.prev + 1) acc.count + 1 else acc.count
                        ),
                        if (value == acc.prev + 1) acc.count + 1 else 1,
                        value
                    )
                }
        }.maxCount
    }
}


fun main() {
    val input = intArrayOf(0,3,7,2,5,8,4,6,0,1)
    println(Solution().longestConsecutive(input))
}