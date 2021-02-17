package com.swarawan.incrementor.db

import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "description")
    var description: String? = null
)