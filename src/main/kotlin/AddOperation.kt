package me.connor

class AddOperation : Operation("+") {
    override fun apply(left: String, right: String): String {
        println("left: $left")
        println("right: $right")
        val leftNum = ExpressionUtils.getRightNumber(left)
        val rightNum = ExpressionUtils.getLeftNumber(right)
        println("left num: $leftNum")
        println("right num: $rightNum")
        println("thing ${left.removeSuffix(leftNum.toString())}")
        return left.removeSuffix(leftNum.toString()) +
                "${leftNum + rightNum}" +
                right.removePrefix(rightNum.toString())
    }
}