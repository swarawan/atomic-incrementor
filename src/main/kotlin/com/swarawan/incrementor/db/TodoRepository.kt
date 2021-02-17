package com.swarawan.incrementor.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

    fun findFirstOrderByIdDesc(): List<Todo>
}