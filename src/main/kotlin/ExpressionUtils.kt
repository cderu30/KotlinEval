package me.connor

object ExpressionUtils {
    fun getLeftNumber(text: String): Double {
        var lastText = ""

        for (char in text.toCharArray()) {
            if (char == '.') {
                lastText += "."
                continue
            }
            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                return lastText.toDouble()
            }
//            if (isNumber(char.toString()))
        }

        return lastText.toDouble()
    }

    fun getRightNumber(text: String): Double {
        var lastText = ""

        val charCount = text.length
        for (i in text.toCharArray().indices) {
            println(i)
            val char = text.toCharArray()[charCount - i - 1]
            if (char == '.') {
                lastText += "."
                continue
            }
            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                lastText = lastText.reversed()
                return lastText.toDouble()
            }
//            if (isNumber(char.toString()))
        }

        lastText = lastText.reversed()
        return lastText.toDouble()
    }

    fun isNumber(text: String): Boolean {
        val v = text.toDoubleOrNull()
        return when(v) {
            null -> false
            else -> true
        }
    }
}