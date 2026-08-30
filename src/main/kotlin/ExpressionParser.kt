package me.connor

import me.connor.LogUtils.devLog
import me.connor.operation.Operation

// iterate through all parens and save the ones that we solved or check isNumber()

object ExpressionParser {
    fun parseExpression(expression: String, debugLogs: Boolean = true) : String {
        devLog(expression, debugLogs)
        var expression = expression
        var evaluatedParens = 0
        loop@while (true) {
            println("expression $expression")

            if (ExpressionUtils.isNumber(expression)) break@loop // solved

//            var lastOpenParenIndex: Int = -1
            val openParensIndices = arrayListOf<Int>()
            val closeParensIndices = arrayListOf<Int>()
            var openParenCount = 0
            for (i in expression.toCharArray().indices) {
                val char = expression[i]
                if (char.toString() == "(") {
//                    lastOpenParenIndex = i
                    openParensIndices.add(i)
//                    openParenCount++
                }
                if (char.toString() == ")") {
                    closeParensIndices.add(i)
//                    openParenCount--
                    devLog(openParensIndices, debugLogs)
//                    if (lastOpenParenIndex != -1) {
                    if (openParensIndices.isNotEmpty()) {
//                        val t = expression.substring(lastOpenParenIndex + 1, i)
//                        if (ExpressionUtils.isNumber(t)) continue
//                        println("paren: $t")
////                        expression = evaluate(t)
//                        expression = expression.replace(t, evaluate(t))
//                        println("evaluated: $expression")
//                        continue@loop

//                        val t = expression.substring(openParensIndices[openParenCount - 1] + 1, i)
//                        if (ExpressionUtils.isNumber(t)) {
//                            openParensIndices.remove(i)
//                            continue
//                        }
//                        println("paren: $t")
////                        expression = evaluate(t)
//                        expression = expression.replace(t, evaluate(t))
//                        println("evaluated: $expression")
//                        continue@loop
                    }
                }
            }

            if (openParensIndices.isNotEmpty() && evaluatedParens < openParensIndices.size) {
                val t = expression.substring(openParensIndices[openParensIndices.size - evaluatedParens - 1] + 1, closeParensIndices[evaluatedParens])
                if (ExpressionUtils.isNumber(t)) {
//                    openParensIndices.remove(i)
                    evaluatedParens++
                    continue
                }
                devLog("paren: $t", debugLogs)
//                        expression = evaluate(t)
                expression = expression.replace(t, evaluate(t, debugLogs))
                devLog("evaluated: $expression", debugLogs)
                continue@loop
            }

            expression = evaluate(expression, debugLogs)
            devLog("finished: $expression", debugLogs)
            return expression

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

        return expression
    }

    fun evaluate(expression: String, debugLogs: Boolean) : String {
        devLog("evaluating: $expression", debugLogs)
        var expression = expression
        while (!ExpressionUtils.isNumber(expression)) {
            var nextOperation: Operation? = null
            var nextOperationIndex = Int.MAX_VALUE

            for (operation in Operations.classes) {
                val index = expression.indexOf(operation.identifier)

                if (index == -1) continue

                if (
                    nextOperation == null ||
                    operation.priority > nextOperation.priority ||
                    (
                            operation.priority == nextOperation.priority &&
                                    index < nextOperationIndex
                            )
                ) {
                    nextOperation = operation
                    nextOperationIndex = index
                }
            }

            if (nextOperation == null) {
                error("failed to eval: $expression")
            }

            val operation = nextOperation
            val raw = expression.split(operation.identifier, limit = 2)

            expression = operation.apply(raw[0], raw[1])
        }

        return expression
    }
}