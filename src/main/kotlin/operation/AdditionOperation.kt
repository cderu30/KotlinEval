package me.connor.operation

import me.connor.ExpressionUtils

class AdditionOperation : Operation("+", 1) {
    override fun apply(left: String, right: String): String {
        val leftNum = ExpressionUtils.getRightNumber(left)
        val rightNum = ExpressionUtils.getLeftNumber(right)
        return left.removeSuffix(leftNum.toString()) +
                "${leftNum + rightNum}" +
                right.removePrefix(rightNum.toString())
    }
}