package com.example.api

import com.example.api.controller.gen.HealthCheckApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
class ApiApplication

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5173")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}

@RestController
class ApiController() : HealthCheckApi {
    override fun ping(): ResponseEntity<String> =
        ResponseEntity.ok("pong")
}
