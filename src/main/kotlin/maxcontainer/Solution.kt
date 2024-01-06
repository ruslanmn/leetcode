package maxcontainer

class Solution {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.lastIndex
        var square = 0

        while (i < j) {
            var s = j - i
            if (height[i] >= height[j]) {
                s *= height[j]
                j--
            } else {
                s *= height[i]
                i++
            }
            if (s > square) square = s
        }

        return square
    }
}

fun main() {
    val input = intArrayOf(3, 2, 3, 1, 1, 2)
    val output = Solution().maxArea(input)
    println(output)
}