import java.util.regex.Pattern

const val NAME_FORMAT = "[a-zA-Z]{3,}\\s[a-zA-Z]{3,}"
const val EMAIL_FORMAT = "[a-z0-9._+%-]+@[a-z0-9]+\\.com(\\.br)?"
const val CPF_FORMAT = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}"
const val PHONE_FORMAT = "\\([\\d]{2}\\)\\s9[\\d]{4}-[\\d]{4}"

fun main() {
    println("Nome Completo: ")
    val name = readln()
    if (!validField(name, NAME_FORMAT)) {
        println("nome invalido")
        return
    }

    println("email: ")
    val email = readln()
    if (!validField(email, EMAIL_FORMAT)) {
        println("email invalido")
        return
    }

    println("cpf: ")
    val cpf = readln()
    if (!validField(cpf, CPF_FORMAT)) {
        println("cpf invalido")
        return
    }

    println("celular: ")
    val phone = readln()
    if (!validField(phone, PHONE_FORMAT)) {
        println("celular invalido")
        return
    }

    println("Formulario enviado com sucesso!")
}

fun validField(field: String, pattern: String): Boolean {
    val pattern = Regex(pattern)
    val fieldIsValid = field.matches(pattern)

    return fieldIsValid
}
