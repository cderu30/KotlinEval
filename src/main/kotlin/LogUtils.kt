package me.connor

object LogUtils {
    fun devLog(message: Any?, debugMode: Boolean) {
        if (debugMode) {
            println(message)
        }
    }
}