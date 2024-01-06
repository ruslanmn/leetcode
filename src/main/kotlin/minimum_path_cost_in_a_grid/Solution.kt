package minimum_path_cost_in_a_grid

import kotlin.math.max

class Solution {
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        val cost = IntArray(grid[0].size) { 0 }

        grid.withIndex().drop(1).forEach { (x, row) ->
            val tmpCost = IntArray(cost.size) { 0 }
            row.forEachIndexed { y, value ->
                tmpCost[y] = grid[x-1].withIndex().map { (fromY, fromValue) ->
                    cost[fromY] + fromValue + moveCost[fromValue][y]
                }.min() ?: -1
            }
            cost.indices.forEach { cost[it] = tmpCost[it] }
        }

        return cost.zip(grid.last()).map { it.first + it.second }.min() ?: -1
    }
}



fun main() {
    val grid = arrayOf(
        intArrayOf(5,3),
        intArrayOf(4,0),
        intArrayOf(2,1)
    )

    val moveCost = arrayOf(intArrayOf(9,8),
        intArrayOf(1,5),
        intArrayOf(10,12),
        intArrayOf(18,6),
        intArrayOf(2,4),
        intArrayOf(14,3)
    )
    
    println(Solution().minPathCost(grid, moveCost))
}