package me.connor

abstract class Operation(val identifier: String) {
    abstract fun apply(left: String, right: String): String
}