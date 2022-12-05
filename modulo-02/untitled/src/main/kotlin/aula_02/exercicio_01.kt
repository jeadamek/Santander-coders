package aula_02

class Company(name: String, quantidadeFuncionarios:Int) {
    var name: String = name
        get() {return field.lowercase()}

    var quantidadeFuncionarios = quantidadeFuncionarios
        set(value) {
            if (quantidadeFuncionarios>1000)
                println("Empresa medio porte")
            field = quantidadeFuncionarios
        }
}

