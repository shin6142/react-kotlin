package com.example.api

import com.example.api.openapi.generated.controller.BankAccountsApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import com.example.api.openapi.generated.controller.HealthCheckApi
import com.example.api.openapi.generated.model.BankAccount
import com.example.attendance.driver.db.tables.references.BANK_ACCOUNTS
import io.swagger.v3.oas.annotations.Parameter
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*


@SpringBootApplication
class ApiApplication {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173")
                    .allowedMethods("GET", "POST", "DELETE")
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}

@RestController
class HealthCheckApiImpl() : HealthCheckApi {
    override fun ping(): ResponseEntity<Unit> =
        ResponseEntity.ok().build()
}

@RestController
class BankAccountsApiImpl(
    private val repository: BankRepository
) : BankAccountsApi {
    override fun getBankAccount(
        @Parameter(
            description = "user id",
            required = true
        ) @PathVariable("user_id") userId: kotlin.String
    ): ResponseEntity<BankAccount> {
        val uuid = UUID.fromString(userId)
        val account = repository.fetchAccount(uuid)
        return ResponseEntity(
            BankAccount(
                account?.id ?: "",
                account?.name ?: "",
                account?.balance ?: 0
            ), HttpStatus.OK
        )
    }
}

@Component
class BankRepository(private val create: DSLContext) {
    fun fetchAccount(userId: UUID): BankAccount? =
        create.selectFrom(BANK_ACCOUNTS).where(BANK_ACCOUNTS.USER_ID.eq(userId)).fetchOne()?.let {
            return BankAccount(it.userId.toString(), "", it.balance ?: 0)
}}