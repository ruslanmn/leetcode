package topkfrequentelements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = nums.toList().groupingBy { it }.eachCount()
        return counts.keys.toList()
            .sortedByDescending { counts[it] }
            .slice(0 until k)
            .toIntArray()
    }
}

fun main() {
    assertEquals(
        Solution().topKFrequent(
            intArrayOf(1,1,1,2,2,3),
            2
        ).toSet(),
        setOf(1, 2)
    )
}

fun <T> assertEquals(actual: T, expected: T) {
    if (actual == expected) {
        println("Success $actual")
    } else {
        println("Fail $actual != $expected")
    }
}
