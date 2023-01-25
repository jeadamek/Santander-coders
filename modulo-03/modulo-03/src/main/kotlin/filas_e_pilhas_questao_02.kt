import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class ShuntingYard {
    val outputQueue: Queue<String> = LinkedList()
    val operatorStack: Stack<String> = Stack()

    fun readToken(expression: String) {
        for (token in expression) {
            when {
                isNumber(token.toString()) -> outputQueue.offer(token.toString())
                isOperator(token.toString()) -> {
                    if (operatorStack.isNotEmpty()){
                      val topOperator = operatorStack.peek()
                      if (TokenHasLowOrSamePriority(token.toString(), topOperator)){
                          outputQueue.add(operatorStack.pop())
                      }
                    }
                    operatorStack.push(token.toString())
                }

                token == '(' -> {
                    operatorStack.push(token.toString())
                }

                token == ')' -> {
                    if (operatorStack.isEmpty())
                        println("Stack empty")
                    while (operatorStack.peek() != "("){
                        outputQueue.add(operatorStack.pop())
                        if (operatorStack.isEmpty())
                            println("Stack empty")
                    }
                    operatorStack.pop()
                }
            }
        }

        while (operatorStack.isNotEmpty()) {
            outputQueue.add(operatorStack.pop())
        }

        val output = outputQueue.joinToString(separator = " ")

        println(output)
    }

    fun isNumber(token: String?): Boolean {
        if (token == null)
            return false
        val isNumber = token.contains(regex = Regex("^[0-9]$"))
        return isNumber
    }

    fun isOperator(token: String?): Boolean{
        if (token == null)
            return false
        val isOperator = token.contains(regex = Regex("[-+*/^x÷]"))
        return isOperator
    }

    fun TokenHasLowOrSamePriority(token: String, topOperator: String?): Boolean{
        if (topOperator == null)
            return false

        val sameToken = token == topOperator
        if (sameToken)
            return false

        val topOperatorPriority = checkPriority(topOperator)
        val tokenPriority = checkPriority(token)

        val priority = topOperatorPriority > tokenPriority || topOperatorPriority == tokenPriority
        return priority
    }

    fun checkPriority(operator: String): Int{
        val priority = when (operator){
            "^" -> 4
            "x" -> 3
            "*" -> 3
            "÷" -> 3
            "/" -> 3
            "+" -> 2
            "-" -> 2
            else -> {
                return 0
            }
        }
        return priority
    }
}


fun main() {
    val sy = ShuntingYard()

    sy.readToken("3 + 4 * 2 ÷ ( 1 - 5 ) ^ 2 ^ 3")
}
