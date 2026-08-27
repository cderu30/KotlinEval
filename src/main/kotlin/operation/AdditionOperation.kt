package me.connor.operation

import me.connor.ExpressionUtils

class AdditionOperation : Operation("+", 1) {
    override fun apply(left: String, right: String): String {
        val leftNum = ExpressionUtils.getRightNumber(left)
        val rightNum = ExpressionUtils.getLeftNumber(right)
        val leftNumStr = ExpressionUtils.untilRightNumber(left)
        val rightNumStr = ExpressionUtils.untilLeftNumber(right)
        return left.removeSuffix(leftNumStr) +
                "${leftNum + rightNum}" +
                right.removePrefix(rightNumStr)
    }
}