package lista_de_exercicios_02

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0

private const val LINHA = ".........."

val valorPaoFrances = 0.60
val valorPaoDeLeite = 0.40
val valorPaoDeMilho = 0.50

val produtoPaoFrances = "Pão Frances"
val produtoPaoDeLeite = "Pão de Leite"
val produtoPaoDeMilho = "Pão de Milho"

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances),
    Pair(produtoPaoDeLeite, valorPaoDeLeite),
    Pair(produtoPaoDeMilho, valorPaoDeMilho)
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
        1 - Coxinha................R$ 5,00
        2 - Esfiha.................R$ 6,00
        3 - Pão de Queijo..........R$ 3,00
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - Carolina...............R$ 1,50
        2 - Pudim..................R$ 4,00
        3 - Brigadeiro.............R$ 2,00
        0 - Voltar
    """.trimIndent()

val itensComanda: MutableList<String> = mutableListOf<String>()
var total: Double = 0.0

fun main() {
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
        }
    } while (finalizarCompra != "S")
}

fun ePadoca(){
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categoria)
        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selecionaProduto(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> println(menuSalgados)
            DOCES -> println(menuDoces)
            else -> Unit
        }

    } while (categoria != FINALIZAR)
}

//fun finalizarPrograma() {
//    if (itensComanda.isEmpty()) {
//        do {
//            println("Deseja mesmo cancelar a compra? [S/N]")
//            val cancelarCompra = readln().uppercase()
//            if (cancelarCompra == "N") {
//                ePadoca()
//            }
//        } while (cancelarCompra != "S" && cancelarCompra != "N")
//    } else {
//        itensComanda.forEach { item ->
//            println(item)
//        }
//        println("Valor total R$$total")
//    }
//}

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
