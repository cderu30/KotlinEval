package me.connor.operation

import me.connor.ExpressionUtils
import kotlin.math.sin

class SineOperation : Operation("sin(", 4) {
    override fun apply(left: String, right: String): String {
        val num = ExpressionUtils.getLeftNumber(right)
        return "$left${sin(num)}${right.removePrefix("$num)")}"
    }
}