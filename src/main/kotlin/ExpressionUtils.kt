package me.connor

object ExpressionUtils {
    fun getLeftNumber(text: String): Double {
        var lastText = ""

        for (char in text.toCharArray()) {
            if (char == '.') {
                lastText += "."
                continue
            }

            if (char == '(') {
                continue
            }

            if (char == ')') {
                continue
            }

            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                return lastText.toDouble()
            }
        }

        return lastText.toDouble()
    }

    fun getRightNumber(text: String): Double {
        var lastText = ""

        val charCount = text.length
        for (i in text.toCharArray().indices) {
            val char = text.toCharArray()[charCount - i - 1]
            if (char == '.') {
                lastText += "."
                continue
            }

            if (char == '(') {
                continue
            }

            if (char == ')') {
                continue
            }

            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                lastText = lastText.reversed()
                return lastText.toDouble()
            }
        }

        lastText = lastText.reversed()
        println("last $lastText")
        return lastText.toDouble()
    }

    fun untilLeftNumber(text: String): String {
        var lastText = ""

        for (char in text.toCharArray()) {
            if (char == '.') {
                lastText += "."
                continue
            }

            if (char == '(') {
                lastText += "("
                continue
            }

            if (char == ')') {
                lastText += ")"
                continue
            }

            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                return lastText
            }
        }

        return lastText
    }

    fun untilRightNumber(text: String): String {
        var lastText = ""

        val charCount = text.length
        for (i in text.toCharArray().indices) {
            val char = text.toCharArray()[charCount - i - 1]
            if (char == '.') {
                lastText += "."
                continue
            }

            if (char == '(') {
                lastText += "("
                continue
            }

            if (char == ')') {
                lastText += ")"
                continue
            }

            if (isNumber(char.toString())) {
                lastText += char.toString()
            } else {
                lastText = lastText.reversed()
                return lastText
            }
        }

        lastText = lastText.reversed()
        return lastText
    }

    fun isNumber(text: String): Boolean {
        val v = text.toDoubleOrNull()
        return when(v) {
            null -> false
            else -> true
        }
    }
}