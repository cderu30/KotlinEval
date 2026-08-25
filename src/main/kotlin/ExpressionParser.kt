package me.connor

import me.connor.operation.Operation

// iterate through all parens and save the ones that we solved or check isNumber()

object ExpressionParser {
    fun parseExpression(expression: String) {
        println(expression)
        var expression = expression
        loop@while (true) {
            if (ExpressionUtils.isNumber(expression)) break@loop // solved

            var lastOpenParenIndex: Int = -1
            var openParenCount = 0
            for (i in expression.toCharArray().indices) {
                val char = expression[i]
                if (char.toString() == "(") {
                    lastOpenParenIndex = i
                    openParenCount++
                }
                if (char.toString() == ")") {
                    openParenCount--
                    println(openParenCount)
                    if (lastOpenParenIndex != -1) {
                        val t = expression.substring(lastOpenParenIndex + 1, i)
                        if (ExpressionUtils.isNumber(t)) continue
                        println("paren: $t")
//                        expression = evaluate(t)
                        expression = expression.replace(t, evaluate(t))
                        println("evaluated: $expression")
                        continue@loop
                    }
                }
            }

            expression = "finished: ${evaluate(" expression ")}"
            println(expression)
            return

//            var nextOperation: Operation? = null
//            var nextOperationIndex = Int.MAX_VALUE
//            for (operation in Operations.classes) {
//                val i = expression.indexOf(operation.identifier)
//                if (i == -1) continue
//                if (i < nextOperationIndex || operation.priority > (nextOperation?.priority ?: Int.MIN_VALUE)) {
//                    nextOperationIndex = i
//                    nextOperation = operation
//                }
//            }
//
//            if (nextOperation != null) {
//                val raw = expression.split(nextOperation.identifier, limit = 2)
//                val result = nextOperation.apply(raw[0], raw[1])
//                expression = result
//                println(result)
//            }
        }
    }

    fun evaluate(expression: String) : String {
        println("evaluating $expression")
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
            }
        }

        return expression
    }
}