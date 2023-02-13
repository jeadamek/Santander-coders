package aula_05

fun main() {
    val phoneFormat = Regex("\\([\\d]{2}\\)\\s9[\\d]{4}-[\\d]{4}")
    println("Digite o numero celular: ")
    val phone = readln()

    val phoneIsValid = phone.matches(phoneFormat)
    if (phoneIsValid)
        println("celular válido")
    else
        println("celular inválido")
}