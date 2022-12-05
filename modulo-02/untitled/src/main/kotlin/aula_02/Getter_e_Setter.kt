package aula_02

class Retangulo(val comprimento: Double, val largura: Double){

    var area: Double = 0.0
        get() = comprimento * largura

}

fun main(){
    val meuRetangulo = Retangulo(comprimento = 10.0, largura = 2.0)

    println(meuRetangulo.area)
}