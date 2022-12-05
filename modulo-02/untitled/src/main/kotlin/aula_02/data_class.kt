package aula_02

// Data Class serve para armazenar dados

data class Guerreiro(
    val nome: String,
    var vida: Int = 20,
    var nivel: String
)

class Guerreiro2(
    val nome: String,
    var vida: Int = 20,
    var nivel: String
)

fun main(){
    val guerreiro1 = Guerreiro("Adalberto Guerreiro", nivel = "Soldado")
    val guerreiro2 = Guerreiro2("Adalberto Guerreiro", nivel = "Soldado")

    // nomeDoPacote.nomeDaClasse@hashCodeEmHexadecimal
    println(guerreiro1.toString())
    // nao vem formatado
    println(guerreiro2.toString())
}