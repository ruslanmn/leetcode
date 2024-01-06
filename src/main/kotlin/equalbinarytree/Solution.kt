package equalbinarytree

import kotlin.math.max
import kotlin.math.min

/*

    cost = v = (v0, v1, v2, ...) - цена перехода на узел Vi с родительского
    s = (s0, s1, s2, ...) где Si = суммарная стоимость прихода на узел Vi

    Пусть есть i и два дочерних узла j и j+1
    Тогда
        j = 2*i + 1   j+1 = 2*i + 2

    2^l - число элементов на уровне
    L(l) = 2^(l+1) - 1    число узлов суммарно на уровнях от 0 до l

    Тогда на уровне l находятся элементы
    2^l - 1 <= i < 2^(l+1) - 1


 */

class Solution {
    fun minIncrements(n: Int, cost: IntArray): Int {
        (0..(cost.size - 3) / 2).forEach { i ->
            cost[2*i+1] += cost[i]
            cost[2*i+2] += cost[i]
        }

        val m = cost.drop((cost.size + 1) / 2 - 1).max()

        ((cost.size + 1) / 2 - 1 until cost.size).forEach { i ->
            cost[i] = m - cost[i]
        }

        (cost.size - 2 downTo  1 step 2).forEach { j ->
            val d = Math.min(cost[j], cost[j+1])
            cost[(j - 1) / 2] = d
            cost[j] -= d
            cost[j+1] -= d
        }

        return cost.sum()
    }
}


fun main() {
    val n = 15
    val cost = intArrayOf(764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761)
    println(Solution().minIncrements(n, cost))
}