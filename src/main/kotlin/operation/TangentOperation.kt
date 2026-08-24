package me.connor.operation

import me.connor.ExpressionUtils
import kotlin.math.tan

class TangentOperation : Operation("tan(", 4) {
    override fun apply(left: String, right: String): String {
        val num = ExpressionUtils.getLeftNumber(right)
        return "$left${tan(num)}${right.removePrefix("$num)")}"
    }
}