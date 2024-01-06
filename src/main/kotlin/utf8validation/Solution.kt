package utf8validation

class Solution {
    fun validUtf8(data: IntArray): Boolean {
        var cursor = 0
        while (cursor < data.size) {
            val size = countFirstOnes(data[cursor])
            if (size == 0 || (2 <= size && size <= 4)) {
                cursor++
                for (i in 1 until size) {
                    if (cursor >= data.size || countFirstOnes(data[cursor]) != 1) {
                        return false
                    }
                    cursor++
                }
            } else {
                return false
            }
        }

        return true
    }

    fun countFirstOnes(i: Int): Int {
        var offset = 7
        while (i.shr(offset).and(1) > 0) {
            offset--
        }

        return 7 - offset
    }
}



fun main() {
    val input = intArrayOf(237)
    println(Solution().validUtf8(input))
    // 11000000
}