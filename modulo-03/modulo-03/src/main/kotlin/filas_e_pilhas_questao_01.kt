import java.util.*
import kotlin.random.Random

data class Message(
    val text: String,
    val recipient: String
){
    var sendAttempt: Int = 0
}

class MessageBroker {
    private val messageSender = Random(1000)
    val queue: Queue<Message> = LinkedList()

    fun processFirstMessage() {

        /*
        * Implementar maneira de processar a fila e de retentar o envio de uma mensagem que deu erro
        */
        //send(message)
        val message = queue.peek()
        val send = send(message)

        while (!send){
            message.sendAttempt++
            if (message.sendAttempt == 3) break;
        }

        if (message.sendAttempt < 3){
            println("""
                Mensagem enviada com sucesso!
                
                Mensagem: ${message.text}
                Destino: ${message.recipient}
                
            """.trimIndent())
            queue.poll()
        } else {
            println("""
                Falha ao enviar a mensagem.
                
                Mensagem: ${message.text}
                Destino: ${message.recipient}
                
            """.trimIndent())
            queue.poll()
        }

    }

    /*
    * Retorna true ao conseguir enviar uma mensagem com sucesso e false se não conseguir
    */
    private fun send(message: Message): Boolean {
        return messageSender.nextBoolean()
    }

    fun addMessage(message: Message){
        queue.offer(message)
    }
}

fun main() {
    val message1 = Message("Hello!", "test@test.com")
    val message2 = Message("Hello there!", "test2@test.com")
    val message3 = Message("Hello there! Good to see u!", "test3@test.com")

    val messageBroker = MessageBroker()
    messageBroker.addMessage(message1)
    messageBroker.addMessage(message2)
    messageBroker.addMessage(message3)

    while (messageBroker.queue.isNotEmpty()){
        messageBroker.processFirstMessage()
    }
}
