package aula_03

import java.util.*

class ExpressionValidator() {

    // apenas validar parenteses
    // utilizando pilha
    fun isValid(expression: String): Boolean {
        val stack = Stack<Char>()
        for (char in expression) {
            when (char) {
                '(' -> stack.push(char)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val expressionValidator = ExpressionValidator()

    println(expressionValidator.isValid("(1 + 2))"))

}