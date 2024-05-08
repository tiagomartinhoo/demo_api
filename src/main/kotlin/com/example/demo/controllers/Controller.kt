package com.example.demo.controllers

import com.example.demo.controllers.models.CreateUserInput
import com.example.demo.services.CustomService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class Controller(private val service: CustomService) {

    @PostMapping("/rest/users")
    fun createUser(
        @RequestBody userCreation: CreateUserInput
    ): ResponseEntity<*> {
        val user = service.createUser(userCreation)
        return ResponseEntity.status(201).body(user)
    }

    @GetMapping("/rest/users/{uid}")
    fun getUserById(
        @PathVariable uid: String
    ): ResponseEntity<*> {
        val user = service.getUserById(uid)
        return ResponseEntity.status(200).body(user)
    }
}