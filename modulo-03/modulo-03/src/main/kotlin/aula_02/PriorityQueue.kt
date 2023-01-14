package aula_02

import java.util.*

data class Person(
    val name: String,
    val age: Int
)

class Bank{

        private val queue: PriorityQueue<Person> = PriorityQueue { new, inQueue ->
        // > 0, < 0, == 0
        if (new.age < 60) 1
        else 0
    }

    fun add(person:Person){
        queue.offer(person)
    }

    fun execute(){
        var current = queue.poll()
        while (current != null){
            println(current)
            current = queue.poll()
        }
    }
}

fun main() {
    val queue = Bank()

   val person1 = Person("Joaquim", 61)
   val person2 = Person("Marco", 14)
   val person3 = Person("Jose", 65)
   val person4 = Person("Marcia", 55)

    queue.add(person1)
    queue.add(person2)
    queue.add(person3)
    queue.add(person4)

    println(queue)
    println(queue.execute())

}

fun priorityQuery(){
        val queue: PriorityQueue<Int> = PriorityQueue { new, inQueue ->
            // > 0, < 0, == 0
            if (new > inQueue) 1
            else 0
        }

        queue.offer(1)
        queue.offer(1)
        queue.offer(3)
        queue.offer(2)

        println(queue)
        println(queue.poll())
        println(queue.poll())
        println(queue.poll())
        println(queue.poll())
}



/*
* Definir classe de pessoa (nome e idade)
* Criar a estrutura de banco (fila, novas pessoas entram no banco, atende)
* Caso a pessoa tenha mais de 60 anos ela te prioridade na fila
* */