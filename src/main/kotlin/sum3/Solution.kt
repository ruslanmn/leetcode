package sum3

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableListOf<List<Int>>()
        val used = mutableSetOf<Pair<Int, Int>>()

        for (i1 in nums.indices) {
            val t1 = nums[i1]

            var i2 = i1 + 1
            var i3 = nums.size - 1

            while (i2 < i3) {
                val t2 = nums[i2]
                val t3 = nums[i3]

                if (t1 > -t2 - t3) {
                    i3--
                } else if (t1 < -t2 - t3) {
                    i2++
                } else {
                    if (used.add(t1 to t2)) {
                        result.add(listOf(t1, t2, t3))
                    }
                    i3--
                }
            }
        }

        return result
    }
}

fun main() {
    val input = intArrayOf(-1,0,1,2,-1,-4)
    println(Solution().threeSum(input))
}