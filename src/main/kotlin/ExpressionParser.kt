package me.connor

object ExpressionParser {
    fun test(expression: String) {
        for (operation in Operations.classes) {
            val raw = expression.split(operation.identifier, limit = 2)
            println("raw: $raw")
            val x = operation.apply(raw[0], raw[1])
            println(x)
        }
    }
}