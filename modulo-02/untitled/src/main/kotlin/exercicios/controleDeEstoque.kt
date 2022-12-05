private const val ADD = 1
private const val EDIT = 2
private const val INVENTORY = 3
private const val ALL_PRODUCTS = 4
private const val END_PROCESS = 0

private const val LINHA = "---------------------"

var inventory: MutableList<Triple<Int, String, Int>> = mutableListOf()
var productID = 1

fun main() {
    mainMenu()
}

fun mainMenu() {
        println("""
        Digite:
        1 - ADICIONAR ITEM
        2 - EDITAR ITEM
        3 - EXIBIR ITENS EM ESTOQUE
        4 - EXIBIR TODOS OS ITENS
        0 - FECHAR SISTEMA
    """.trimIndent())
        val entry = readln().toIntOrNull()

    try {
        when (entry){
            ADD -> addProduct()
            EDIT -> editProduct()
            INVENTORY -> showInventory()
            ALL_PRODUCTS -> showAllProducts()
            END_PROCESS -> exitProcess()
            else -> throw InvalidEntry()
        }
    } catch (e: InvalidEntry){
        println("Opção digitada inválida")
    } finally {
        mainMenu()
    }
}

fun exitProcess() {
    System.exit(0)
}

fun addProduct(){
    println("Nome do produto:")
    val productName = readln()

        try {
            println("Quantidade em estoque:")
            val productQuantity = readln().toInt()

            when (productQuantity) {
                in 1..999 -> inventory.add(Triple<Int, String, Int>(productID, productName, productQuantity))
                in 999..Int.MAX_VALUE -> throw LimiteEstoqueMaxExcpetion()
                in Int.MIN_VALUE..0 -> throw ProductExceededMinimumValue()
            }
            println("Item adicionado com sucesso!")
            productID++
        } catch (e: ProductExceededMinimumValue){
            println("Produto não registrado. Quantidade não pode ser menor que 1")
        } catch (e: LimiteEstoqueMaxExcpetion){
            println("Produto não registrado. Quantidade não pode ser maior que 999")
        } catch (e: NumberFormatException){
            println("Produto não registrado. Quantidade Invalida.")
        } finally {
            var addOrGoBack: Int
            do {
                println("""
                    Digite:
                    1 - Adicionar novo produto
                    0 - Voltar ao menu inicial
                """.trimIndent())
                addOrGoBack = readln().toInt()

                when (addOrGoBack){
                    1 -> addProduct()
                    0 -> mainMenu()
                }
            } while (addOrGoBack != 1 && addOrGoBack != 0)
        }
}

fun editProduct(){
    println("ID    | Peça     | Quantidade")
    inventory.forEach{ it ->
        println("#000${it.first} | ${it.second} | ${it.third}")
    }

    try {
        print("Digite o ID do produto a ser editado ou 0 para voltar: #")
        val editProductID = readln().toInt()

        if (editProductID == 0) {
            mainMenu()
        }

        val productID = findProduct(editProductID)

        if (productID == 0){
            println("ID não encontrado")
            editProduct()
        }

        updateProduct(productID)
    } catch (e: NumberFormatException) {
        println("ID Inválido")
    } finally {
        editProduct()
    }
}


fun findProduct (productID: Int): Int{
    inventory.forEach{it ->
        if (it.first == productID){
            return it.first
        }
    }
    return 0
}

fun updateProduct(productID: Int){
    println("Digite o novo nome ou enter para editar a quantidade")
    val productNewName = readln()

    try {
        println("Digite a quantidade atualizada")
        val productNewQuantity = readln().toInt()

        var productName = inventory[productID - 1].second

        if (productNewName != ""){
            productName = productNewName
        }

        when (productNewQuantity) {
            in 0..999 -> inventory[productID - 1] = Triple(productID, productName, productNewQuantity)
            in 999..Int.MAX_VALUE -> throw LimiteEstoqueMaxExcpetion()
            in Int.MIN_VALUE..-1 -> throw ProductExceededMinimumValue()
        }

    } catch (e: LimiteEstoqueMaxExcpetion){
        println("Estoque não pode ser maior que 999")
    } catch (e: ProductExceededMinimumValue) {
        println("Estoque não pode ser negativo")
    } catch (e: NumberFormatException) {
        println("Quantidade Invalida.")
    }
}

fun showInventory(){
    println("ID    | Peça     | Quantidade")
    inventory.forEach{ it ->
        if (it.third > 0){
            println("#000${it.first} | ${it.second} | ${it.third}")
        }
    }
    println("Pressione enter voltar ao menu incial")
    readln()
    mainMenu()
}

fun showAllProducts(){
    println("ID    | Peça     | Quantidade")
    inventory.forEach{ it ->
        println("#000${it.first} | ${it.second} | ${it.third}")
    }
    println("Pressione enter voltar ao menu incial")
    readln()
    mainMenu()
}

//ERROS
class InvalidEntry: Exception(){
    override fun getLocalizedMessage(): String {
        return "Erro: opção desejada não encontrada no menu"
    }
}

class LimiteEstoqueMaxExcpetion: Exception(){
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade de produto maior que 999"
    }
}

class ProductExceededMinimumValue: Exception (){
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade de produto menor que zero"
    }
}