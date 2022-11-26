package lista_de_exercicios_02

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0

private const val LINHA = ".........."

// VALORES
val valorPaoFrances = 0.60
val valorPaoDeLeite = 0.40
val valorPaoDeMilho = 0.50

val valorCoxinha = 5.00
val valorEsfiha = 6.00
val valorPaoDeQueijo = 3.00

val valorCarolina = 1.50
val valorPudim = 4.00
val valorBrigadeiro = 2.00

// PRODUTOS
val produtoPaoFrances = "Pão Frances"
val produtoPaoDeLeite = "Pão de Leite"
val produtoPaoDeMilho = "Pão de Milho"

val produtoCoxinha = "Coxinha"
val produtoEsfiha = "Esfiha"
val produtoPaoDeQueijo = "Pão de Queijo"

val produtoCarolina = "Carolina"
val produtoPudim = "Pudim"
val produtoBrigadeiro = "Brigadeiro"

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances),
    Pair(produtoPaoDeLeite, valorPaoDeLeite),
    Pair(produtoPaoDeMilho, valorPaoDeMilho)
)

val salgados: List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha),
    Pair(produtoEsfiha, valorEsfiha),
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo)
)

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina),
    Pair(produtoPudim, valorPudim),
    Pair(produtoBrigadeiro, valorBrigadeiro)
)

val categoria = """
        Digite a opção desejada no Menu:
        1..................Pães
        2..............Salgados
        3.................Doces
        0......Finalizar compra 
    """.trimIndent()

val menuPaes = """
        1 - Pão Francês...........R$ $valorPaoFrances
        2 - Pão de Leite..........R$ $valorPaoDeLeite
        3 - Pão de Milho..........R$ $valorPaoDeMilho
        0 - Voltar
    """.trimIndent()

val menuSalgados = """
        1 - Coxinha................R$ $valorCoxinha
        2 - Esfiha.................R$ $valorEsfiha
        3 - Pão de Queijo..........R$ $valorPaoDeQueijo
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - Carolina...............R$ $valorCarolina
        2 - Pudim..................R$ $valorPudim
        3 - Brigadeiro.............R$ $valorBrigadeiro
        0 - Voltar
    """.trimIndent()

val itensComanda: MutableList<String> = mutableListOf<String>()
var total: Double = 0.0

fun main() {
    finalizarPrograma()
}

fun ePadoca(){
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categoria)
        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selecionaProduto(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> selecionaProduto(menuSelecionado = menuSalgados, produtos = salgados)
            DOCES -> selecionaProduto(menuSelecionado = menuDoces, produtos = doces)
            else -> Unit
        }

    } while (categoria != FINALIZAR)
}

fun finalizarPrograma() {
    do {
        var finalizarCompra = "S"
        ePadoca()

        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            itensComanda.forEach { item -> // funcao
                println(item)
            }
            println("Valor total R$$total")

            promocao(total)
        }
    } while (finalizarCompra != "S")
}

fun selecionaProduto(
    menuSelecionado: String,
    produtos: List<Pair<String, Double>>
){
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt()

        for ((i, produto) in produtos.withIndex()){
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }
    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item =
        itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA$valorUnitario${LINHA}R$$total"

fun promocao(total: Double){
    var aplicarCupomDeDesconto: String
    do{
        println("Aplicar cupom de desconto? [S/N]")
        aplicarCupomDeDesconto = readln().uppercase()
    } while (aplicarCupomDeDesconto != "S" && aplicarCupomDeDesconto != "N")

    if (aplicarCupomDeDesconto == "S") {
        val desconto = aplicarCupomDeDesconto(total)
        val totalComDesconto = total - desconto

        println("Desconto de R$$desconto aplicado")
        println("Valor total R$$totalComDesconto")
    }
}

fun aplicarCupomDeDesconto(total: Double): Double{
    println("Insira o Cupom:")
    val cupom = readln().uppercase()
    var desconto = 0.0

    when (cupom) {
        "5PADOCA" -> desconto = (total * 5) / 100
        "10PADOCA" -> desconto = (total * 10) / 100
        "5OFF" -> desconto = total - 5
        else -> {
            println("Cupom Invalido.")
        }
    }

    return desconto
}
