package aula_01

fun CalculoConsumo(potencia: Int, horas: Int, dias: Int){
    val kwh = (potencia * horas * dias) / 1000
    print("Esse equipamento gasta ${kwh} kwh em ${dias}")
}


fun main() {
    CalculoConsumo(1000, 200, 30)
}