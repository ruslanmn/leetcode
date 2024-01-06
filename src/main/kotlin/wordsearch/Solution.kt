package wordsearch


class Solution {
    var word: String = ""
    var board: Array<CharArray> = arrayOf()
    var h: Int = 0
    var w: Int = 0
    var memo = mutableSetOf<Int>()

    fun exist(board: Array<CharArray>, word: String): Boolean {
        this.board = board
        this.word = word

        this.h = board.size
        this.w = board[0].size

        return (0 until h).any {y ->
            (0 until w).any { x ->
                exists(0, x, y)
            }
        }
    }

    fun exists(letterInd: Int, x: Int, y: Int): Boolean {
        if (letterInd >= word.length) return true
        if (!memo.add(y*w + x)) return false

        if (x in 0 until w
            && y in 0 until h
            && board[y][x] == word[letterInd]
            && (exists(letterInd+1, x+1, y)
                || exists(letterInd+1, x-1, y)
                || exists(letterInd+1, x, y+1)
                || exists(letterInd+1, x, y-1))
        ) return true

        memo.remove(y*w + x)
        return false
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('C','A','A'),
        charArrayOf('A','A','A'),
        charArrayOf('B','C','D')
    )
    val word = "AAB"
    println(Solution().exist(board, word))
}