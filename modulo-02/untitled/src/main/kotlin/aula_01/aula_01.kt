package aula_01

import java.util.*

class Funcionario(
    val id: Int,
    var nome: String,
    var sobrenome: String,
    val cpf: String,
    var cargo: String,
    var salario: Double = 0.0
) {

    init {
        // bloco inicial a ser executado
        nome = nome.uppercase(Locale.getDefault())
        sobrenome = sobrenome.uppercase(Locale.getDefault())
    }

    constructor(nome: String, sobrenome: String,cpf: String): this(0, nome, sobrenome, cpf, "Desconhecido", 0.0)


}

fun main(){

    val funcionario1 = Funcionario(
        0,
        "Joao",
        "Silva",
        "123457889",
        "Zelador",
        1000.0
    )

    val funcionario2 = Funcionario("abc", "Silva", "123456789")
}