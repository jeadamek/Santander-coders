package aula_05

import java.util.*

fun main() {
    val treeMap: MutableMap<Int, String> = TreeMap<Int, String>()
    val treeSet = TreeSet<Int>()

    treeMap.put(1, "asdf")
    treeMap.containsKey(1)

    println(treeMap)
}