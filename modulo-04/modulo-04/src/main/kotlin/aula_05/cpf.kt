package aula_05

fun main() {
    val cpfFormat = Regex("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}")
    println("Digite CPF: ")
    val cpf = readln()

    val cpfIsValid = cpf.matches(cpfFormat)
    if (cpfIsValid)
        println("CPF válido")
    else
        println("CPF inválido")
}