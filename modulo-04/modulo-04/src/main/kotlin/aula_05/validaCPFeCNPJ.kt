package aula_05

fun main() {
    val pattern = Regex("(^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}\$)|(^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}\$)")
    println("Digite CNPJ ou CPF: ")
    val value = readln()

    val isValid = value.matches(pattern)

    if (isValid){
        val isCPF = value.length == 14
        when {
            isCPF -> println("CPF válido")
            else -> println("CNPJ válido")
        }
    }
    else
        println("Valor inválido")
}