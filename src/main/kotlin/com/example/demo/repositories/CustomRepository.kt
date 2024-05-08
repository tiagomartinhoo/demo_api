package com.example.demo.repositories

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomRepository : MongoRepository<User, String> {

    fun findByName(name: String): User?
}