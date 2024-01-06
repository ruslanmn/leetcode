package minimumspeedtoarriveontime

class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        if (dist.size - 1 >= hour) {
            return -1
        }

        var l = (dist.sum()/hour).toInt() - 1
        var r = Math.max((dist.last() / (hour - dist.size + 1)).toInt() + 1, dist.max()!!)

        while (l + 1 < r) {
            val m = (l + r) / 2
            val time = dist.last().toDouble() / m + dist.dropLast(1)
                .map { Math.ceil(it / m.toDouble()) }
                .sum()

            if (time > hour) {
                l = m
            } else {
                r = m
            }
        }

        return r
    }
}


fun main() {
    val dist = intArrayOf(1,1)
    val hour = 1.0
    println(Solution().minSpeedOnTime(dist, hour))
}