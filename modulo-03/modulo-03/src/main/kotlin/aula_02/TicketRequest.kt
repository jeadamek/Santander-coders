package aula_02

import java.util.*
import aula_02.TicketRequest

data class TicketRequest(
    val name: String,
    val waitingTime: Int
)


class TicketManager {
    private val queue: Queue<TicketRequest> = LinkedList()
    private var currentSong: String? = null

    fun addTicket(ticket: TicketRequest) {
        queue.offer(ticket)
    }

    fun resolve() {
        var currentTicketRequest: TicketRequest?
        currentTicketRequest = queue.poll()
        while (currentTicketRequest != null) {
            if (currentTicketRequest.waitingTime < 10) {
                println("Resolvendo Ticket ${currentTicketRequest.name}")
            } else {
                println("${currentTicketRequest.name} Cancelado")
            }
            currentTicketRequest = queue.poll()
        }
    }
}

/*
* Criar uma estrutura para tratar um ticket de suporte, tratar apenas com waiting time
* menor que 10
* */

fun main() {
    val queue = TicketManager()

    queue.addTicket(TicketRequest("jonas", 9))
    queue.addTicket(TicketRequest("Queen", 3))
    queue.addTicket(TicketRequest("kimmy", 10))
    queue.addTicket(TicketRequest("kill", 15))
    queue.addTicket(TicketRequest("mirela", 5))
    queue.addTicket(TicketRequest("Marcos", 1))

    queue.resolve()
}