package me.connor

import me.connor.operation.*

object Operations {
    val classes = listOf(
        AdditionOperation(),
        SubtractionOperation(),
        MultiplicationOperation(),
        DivisionOperation(),
        SquareRootOperation(),
        ExponentOperation(),
        SineOperation(),
        CosineOperation(),
        TangentOperation()
    )

    init {
        classes.sortedByDescending { it.priority }
    }
}