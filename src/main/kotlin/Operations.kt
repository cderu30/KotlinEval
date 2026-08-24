package me.connor

object Operations {
    val classes = listOf(AdditionOperation(), SubtractionOperation())
    init {
        classes.sortedByDescending { it.priority }
    }
}