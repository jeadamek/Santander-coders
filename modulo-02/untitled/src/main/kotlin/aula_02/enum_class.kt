package aula_02

// Classes que enumeram e armazenam objetos fixos de forma sequencial

//enum class enumName{
//    Case1, Case2, Case3
//}

enum class NivelGuerreiro(val nome: String, val arma: Arma){
    SOLDADO(nome= "Soldado", arma=Arma("Pistola", dano = 4)) {
        override fun superDano(): Int {
            return arma.dano * 2
        }
    },
    GUARDA(nome= "Guarda", arma=Arma("Escopeta", dano = 10)) {
        override fun superDano(): Int {
            return arma.dano * 2
        }
    },
    GENERAL(nome= "General", arma=Arma("Fuzil", dano = 14)) {
        override fun superDano(): Int {
            return arma.dano * 2
        }
    },
    CELESTIAL(nome= "Celestial", arma=Arma("Espada de Luz", dano = 30)) {
        override fun superDano(): Int {
            return arma.dano * 4
        }
    },
    APOCALIPTICO(nome= "Apocaliptico", arma=Arma("Machado das Trevas", dano = 65)) {
        override fun superDano(): Int {
            return arma.dano * 5
        }
    },
    DEUS_DOS_DEUSES(nome= "Deus dos Deuses", arma=Arma("Biblia Sagrada", dano = 150)) {
        override fun superDano(): Int {
            return arma.dano * 10
        }
    };

    override fun toString():String {
        return "NivelGuerreiro(nome=$nome, arma=$arma)"

    }

    // todos os itens precisam implementar essa funcao
    abstract fun superDano(): Int
}

data class Arma(val nome: String, val dano: Int)

fun main(){
    println(NivelGuerreiro.SOLDADO.toString())
    println(NivelGuerreiro.SOLDADO.name)
    println(NivelGuerreiro.SOLDADO.ordinal)


    println(NivelGuerreiro.SOLDADO.nome)
    println(NivelGuerreiro.SOLDADO.arma)
}