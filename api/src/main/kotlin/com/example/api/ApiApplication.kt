package com.example.api

import com.example.api.controller.gen.HealthCheckApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

import org.springframework.http.ResponseEntity
import java.util.*


@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}

@RestController
class ApiController() : HealthCheckApi {
    override fun ping(): ResponseEntity<String> =
        ResponseEntity.ok("pong")
}