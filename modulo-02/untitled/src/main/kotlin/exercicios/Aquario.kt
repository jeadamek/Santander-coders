package exercicios

import exercicios.TamanhoAquario.*

enum class TamanhoAquario(val nome: String, val abreviacao: String, val capacidade: Int){
    PEQUENO("Pequeno", "P", 5),
    MEDIO("Medio", "M", 10),
    GRANDE("Grande", "G" , 15);

}

data class Peixe(val nome: String, val cor: String, val tamanho: String)

class Aquario(var quantidadePeixes: Int = 0,
              var peixes: MutableList<Peixe> = mutableListOf(),
              var sujo: Boolean = false,
              var tamanho: TamanhoAquario = PEQUENO,
              val maximoDePeixesParaLimpeza: Int = 3
              )
{

    fun adicionar(peixe: Peixe){
        if(tamanho.capacidade == quantidadePeixes){
            println("Quantidade maxima de peixes atingida. De updrade no aquario para adicionar mais peixes")
            return
        }

        if(!sujo) {
            peixes.add(peixe)
            quantidadePeixes++
            if (quantidadePeixes % maximoDePeixesParaLimpeza == 0) sujo = true
        } else {
            println("Aquario sujo! Limpe-o para adicionar mais peixes.")
        }
    }

    fun alimentar(){

        if (quantidadePeixes == 0) {
            println("Aquario vazio. Adicione Peixes para alimenta-los")
            return
        }
        val alimento = (0 ..quantidadePeixes).random()

        when (alimento){
            0 -> println("Falha, nenhum peixe se alimentou.")
            quantidadePeixes -> println("Sucesso, todos os peixes se alimentaram")
            else -> println("Parcial, alguns peixes se alimentaram. Alimento = $alimento, peixes no aquario = $quantidadePeixes")
        }
    }

    fun limpar(){
        if(sujo){
            println("Limpando aquario... Aquario Limpo!")
            sujo = false
        } else {
            println("Aquario não está sujo")
        }
    }

    fun updrade(){
        when(tamanho) {
            PEQUENO -> {
                tamanho = MEDIO
                println("Parabens! Upgrade realizado com sucesso!")
            }
            MEDIO -> {
                tamanho = GRANDE
                println("Parabens! Upgrade realizado com sucesso!")
            }
            else -> println("Upgrade maximo de aquario alcançado")
        }
    }
}

fun main() {
    val aquario = Aquario()
    iniciarAquario(aquario)
}

fun iniciarAquario(aquario: Aquario){

    println("""
        O que deseja fazer?
        1 - Adicionar Peixe
        2 - Alimentar Peixes
        3 - Limpar Aquario
        4 - Upgrade Aquario
    """.trimIndent())
    val acao = readln().toInt()

    when(acao){
        1 -> aquario.adicionar(criarPeixe())
        2 -> aquario.alimentar()
        3 -> aquario.limpar()
        4 -> aquario.updrade()
    }

    iniciarAquario(aquario)
}

private fun criarPeixe(): Peixe {
    println("Nome do peixe:")
    val nome = readln()
    println("Cor do peixe:")
    val cor = readln()
    println("Tamanho:")
    val tamanho = readln()

    val peixe = Peixe(nome, cor, tamanho)
    return peixe
}


