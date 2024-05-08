package com.example.demo.repositories

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users_container")
data class User(
    @Id
    val id: String,
    val name: String,
    val password: String
)