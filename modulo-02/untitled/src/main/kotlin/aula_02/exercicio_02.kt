package aula_02

data class Passaro(
    val tipo: String,
    val cor: String,
    val voa: Boolean){

    fun voar(){
        if (voa)
            println("Passaro voando")
        else
            println("$tipo nao voa")
    }

    fun comer(){
        println("Passaro comendo")
    }
}

fun main(){
    val galinha = Passaro("galinha", "branca",false)

    galinha.voar()
}