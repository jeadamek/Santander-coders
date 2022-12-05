package aula_02

//Desenvolva um sistema que possibilite o usuuario acirar uma EMPRESA(nome, cnpj, segmento, ..)
// e inserir, modificar, remover e mostrar FUNCIONARIOS (id, nome, sobrenome, cargo, salario, ...)

class Funcionario(val nome: String, val sobrenome: String, var cargo: String, var salario: Double){
    override fun toString(): String{
        return """
            Funcionario(nome: $nome, sobrenome: $sobrenome, cargo = $cargo, salario = $salario)
        """.trimIndent()
    }
}

class Empresa(
    val nome: String,
    val cnpj: String,
    val segmento: String,
    var listaFuncionarios: MutableList<Funcionario> = mutableListOf()
){

    fun inserirFuncionario(funcionario: Funcionario){
        // adicionar esse funcionario na minha lista de funcionarios
        listaFuncionarios.add(funcionario)
    }

    fun mostrarFuncionarios(){
        println(listaFuncionarios.toList())
    }

    fun retornaFuncionarios(): List<Funcionario>{
        return listaFuncionarios.toList()
    }

    fun removerFuncionario(nome: String, sobrenome: String){
        // find retorna o primeiro elemento que der match ou nulo caso o elemento nao for encontrado
        val retornoDaBusca: Funcionario? = buscaFuncionarioNaLista(nome, sobrenome)
        val retornoDaRemocao: Boolean = listaFuncionarios.remove(retornoDaBusca)

        if (retornoDaRemocao)
            println("Funcionario removido com sucesso!")
        else
            println("Funcionario nao se encontra na lista")
    }

    fun modificarFuncionario(nome: String, sobrenome: String, novoCargo: String, novoSalario: Double){
        // encontar o funcionario, depois de encontrado, alterar seus campos
        val funcionarioASarModificado: Funcionario? = buscaFuncionarioNaLista(nome, sobrenome)

        funcionarioASarModificado?.apply {
            this.cargo = novoCargo
            this.salario = novoSalario
        }
    }

    fun buscaFuncionarioNaLista(nome: String, sobrenome: String): Funcionario? =
        listaFuncionarios.find { it.nome == nome && it.sobrenome == sobrenome}

}

fun main(){
    // CRTL + P --> mostra os paramentros esperados pela funcao
    val santander = Empresa("Santander", "12345678", "Banco")

    val jessicaGalliAdamek = Funcionario("Jessica", "Galli Adamek", "Gerente", 6_000.0)

    santander.inserirFuncionario(jessicaGalliAdamek)

    santander.mostrarFuncionarios()


}