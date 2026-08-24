package me.connor

import me.connor.operation.Operation

object ExpressionParser {
    fun parseExpression(expression: String) {
        println(expression)
        var expression = expression
        loop@ while (true) {
            if (ExpressionUtils.isNumber(expression)) break@loop
            var nextOperation: Operation? = null
            var nextOperationIndex = Int.MAX_VALUE
            for (operation in Operations.classes) {
                val i = expression.indexOf(operation.identifier)
                if (i == -1) continue
                if (i < nextOperationIndex || operation.priority > (nextOperation?.priority ?: Int.MIN_VALUE)) {
                    nextOperationIndex = i
                    nextOperation = operation
                }
            }

            if (nextOperation != null) {
                val raw = expression.split(nextOperation.identifier, limit = 2)
                val result = nextOperation.apply(raw[0], raw[1])
                expression = result
                println(result)
            }
        }
    }
}