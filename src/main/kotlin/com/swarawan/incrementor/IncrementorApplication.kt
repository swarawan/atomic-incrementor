package com.swarawan.incrementor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.text.SimpleDateFormat
import java.util.*

@SpringBootApplication
class IncrementorApplication

fun main(args: Array<String>) {
	runApplication<IncrementorApplication>(*args)
}

fun Date?.convert(
	pattern: String = "yyyy-MM-dd HH:mm:ss",
	locale: Locale = Locale.getDefault(Locale.Category.FORMAT)
): String = when (this) {
	null -> "---"
	else -> SimpleDateFormat(pattern, locale).format(this)
}