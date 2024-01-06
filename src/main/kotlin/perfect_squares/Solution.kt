package perfect_squares


/*
 *      n = sum a[i]*k[i]^2
 *
 *
 *      12 = 2^2 + 2^2 + 2^2
 *      8 = 2^2 + 2^2
 *      12 = 3^2 + 1 + 1 + 1
 *      8 = 2^2 + 1 + 1 + 1 + 1 + 1
 *
 */

class Solution {
    val memo = mutableMapOf<Int, Pair<Int, Int>>()

    fun numSquares(n: Int): Int {
        var l = 1
        var r = n+1

        while (r*r > n) {
            val m = (l + r) / 2 + (l+r) % 2
            if (m*m > n) {
                r = m - 1
            } else {
                l = m
            }
        }

        return numSquares(n, r)
    }

    fun numSquares(n: Int, k: Int): Int {
        return if (n == 0) {
            0
        } else if (k == 1) {
            n
        } else {
            memo.get(n)?.let {
                if (it.first >= k) {
                    it.second
                } else {
                    null
                }
            } ?: (1 + (k downTo 1)
                .filter { n - it * it >= 0 }
                .map {
                    numSquares(n - it * it, it)
                }.min()).also {
                    memo.put(n, k to it)
            }
        }
    }
}

fun main() {
    val input = 70
    println(Solution().numSquares(input))
}