package me.connor.operation

import me.connor.ExpressionUtils
import kotlin.math.sqrt

class SquareRootOperation : Operation("sqrt(", 4) {
    override fun apply(left: String, right: String): String {
        val num = ExpressionUtils.getLeftNumber(right)
        return "$left${sqrt(num)}${right.removePrefix("$num)")}"
    }
}