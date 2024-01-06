package validparenthesis

import java.util.Stack

class Solution {
    val parentheses = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        s.toCharArray()
            .forEach {
                if (parentheses.contains(it)) {
                    stack.push(it)
                } else if (stack.isEmpty() || parentheses[stack.pop()] != it) {
                    return false
                }
            }

        return stack.isEmpty()
    }
}