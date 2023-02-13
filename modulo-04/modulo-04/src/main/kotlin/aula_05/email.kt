package aula_05

fun main() {
    val emailFormat = Regex("[a-z0-9._+%-]+@[a-z0-9]+\\.com(\\.br)?")
    println("Digite o email: ")
    val email = readln()

    val emailIsValid = email.matches(emailFormat)
    if (emailIsValid)
        println("email válido")
    else
        println("email inválido")
}