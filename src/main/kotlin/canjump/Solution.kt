package canjump

import kotlin.math.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val maxReached = nums.withIndex()
            .fold(0) { reached, (i, steps) ->
                if (i > reached)
                    reached
                else
                    Math.max(reached, i + steps)
            }

        return maxReached >= nums.lastIndex
    }
}

fun main() {
    val input = intArrayOf(2,3,1,1,4)
    println(Solution().canJump(input))
}