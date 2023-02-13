package aula_05

fun main() {
    val valueFormat = Regex("R\\\$\\s[\\d]+,[\\d]{2}")
    println("Digite o valor: ")
    val value = readln()

    val valueIsValid = value.matches(valueFormat)
    if (valueIsValid)
        println("Valor válido")
    else
        println("Valor inválido")
}