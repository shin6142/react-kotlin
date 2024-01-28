package com.example.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import com.example.api.openapi.generated.controller.HealthCheckApi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import java.util.*


@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}

@RestController
class ApiController() : HealthCheckApi {
    override fun ping(): ResponseEntity<Unit> = 
        ResponseEntity.ok().build()
}