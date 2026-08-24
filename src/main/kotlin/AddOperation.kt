package me.connor

class AddOperation : Operation("+") {
    override fun apply(left: String, right: String): String {
        println("left: $left")
        println("right: $right")
        return ""
    }
}