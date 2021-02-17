package com.swarawan.incrementor.controller

import com.swarawan.incrementor.convert
import com.swarawan.incrementor.db.Todo
import com.swarawan.incrementor.db.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping(value = ["/incrementor"], produces = [MediaType.APPLICATION_JSON_VALUE])
class IncrementorController @Autowired constructor(private val todoRepository: TodoRepository) {

    private val count = AtomicInteger()

    @GetMapping
    fun printIncrement(): ResponseEntity<Any> {

        val name = incrementId()
        println("${Date().convert("HH:mm:ss")} $name")

        todoRepository.save(Todo(name = name))
        return ResponseEntity(true, HttpStatus.OK)
    }

    private fun incrementId(): String {
        var currentValue = count.get()
        var newValue = currentValue + 1

        while (!count.compareAndSet(currentValue, newValue)) {
            currentValue = count.get()
            newValue = currentValue + 1
        }

        return "--$newValue"
    }
}