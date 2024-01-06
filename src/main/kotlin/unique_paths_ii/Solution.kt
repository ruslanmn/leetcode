package unique_paths_ii

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        obstacleGrid.indices.forEach {  y ->
            obstacleGrid[y].indices.forEach { x ->
                obstacleGrid[y][x] = (if (obstacleGrid[y][x] == 1)
                    0
                else
                    if (x == 0 && y == 0) 1 else
                    ((if (y > 0) obstacleGrid[y - 1][x] else 0)
                        + (if (x > 0) obstacleGrid[y][x - 1] else 0)))
            }
        }

        return obstacleGrid.last().last()
    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0)
    )
    println(Solution().uniquePathsWithObstacles(input))
}