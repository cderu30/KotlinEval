package me.connor.operation

// lower number priority gets executed later
abstract class Operation(val identifier: String, val priority: Int) {
    abstract fun apply(left: String, right: String): String
}