package longestsubstring

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val letterLastIndex = mutableMapOf<Char, Int>()
        var maxLen = 0

        for ((i, letter) in s.withIndex()) {
            letterLastIndex[letter]?.also { ind ->
                maxLen = max(maxLen, letterLastIndex.size)
                letterLastIndex.removeIf { it.value < ind + 1 }
            }
            letterLastIndex[letter] = i
        }
        maxLen = max(maxLen, letterLastIndex.size)
        return maxLen
    }
}

fun MutableMap<Char, Int>.removeIf(predicate: (Map.Entry<Char, Int>) -> Boolean) {
    entries
        .filter { predicate(it) }
        .forEach { remove(it.key) }
}


fun main() {
    val input = "cdd"
    val output = 3
    println(Solution().lengthOfLongestSubstring(input))
}