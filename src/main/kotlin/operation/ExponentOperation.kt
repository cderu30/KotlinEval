package me.connor.operation

import me.connor.ExpressionUtils
import kotlin.math.pow

class ExponentOperation : Operation("^", 3) {
    override fun apply(left: String, right: String): String {
        val leftNum = ExpressionUtils.getRightNumber(left)
        val rightNum = ExpressionUtils.getLeftNumber(right)
        return left.removeSuffix(leftNum.toString()) +
                "${leftNum.pow(rightNum)}" +
                right.removePrefix(rightNum.toString())
    }
}