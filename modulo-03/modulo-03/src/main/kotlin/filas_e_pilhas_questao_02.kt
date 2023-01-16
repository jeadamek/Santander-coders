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
                isOperator(token.toString()) -> operatorStack.push(token.toString())
            }
        }

        val output = outputQueue.joinToString(separator = " ")
        
        println(output)
    }

    fun isNumber(token: String): Boolean {
        val isNumber = token.contains(regex = Regex("^[0-9]$"))
        return isNumber
    }

    fun isOperator(token: String): Boolean{
        val isOperator = token.contains(regex = Regex("[-+x/^]"))
        return isOperator
    }


}


fun main() {
    val sy = ShuntingYard()

    sy.readToken("3+4")
}
