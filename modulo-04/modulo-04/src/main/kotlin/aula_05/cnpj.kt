package aula_05

fun main() {
    val cnpjFormat = Regex("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}")
    println("Digite CNPJ: ")
    val cnpj = readln()

    val cnpjIsValid = cnpj.matches(cnpjFormat)
    if (cnpjIsValid)
        println("CNPJ válido")
    else
        println("CNPJ inválido")
}