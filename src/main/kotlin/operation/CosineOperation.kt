package me.connor.operation

import me.connor.ExpressionUtils
import kotlin.math.cos

class CosineOperation : Operation("cos(", 4) {
    override fun apply(left: String, right: String): String {
        val num = ExpressionUtils.getLeftNumber(right)
        return "$left${cos(num)}${right.removePrefix("$num)")}"
    }
}