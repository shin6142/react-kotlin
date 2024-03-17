package com.example.api.controller.user

import com.example.api.controller.gen.User
import com.example.api.controller.gen.UserApi
import com.example.api.driver.UserDriver
import com.example.api.driver.db.tables.records.UserDetailsRecord
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserControllerImpl(
    private val userDriver: UserDriver
) : UserApi {
    override fun getUsers(): ResponseEntity<List<User>> {
        val records = userDriver.fetchUsers()
        val users = records.map {
            User(
                userId = it.userId ?: return ResponseEntity(HttpStatus.NOT_FOUND),
                userName = it.username ?: return ResponseEntity(HttpStatus.NOT_FOUND)
            )
        }
        return ResponseEntity(users, HttpStatus.OK)
    }

    override fun getUser(userId: UUID): ResponseEntity<User> {
        val record = userDriver.fetchUser(userId) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val id = record.userId ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val userName = record.username ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(
            User(
                userId = id,
                userName = userName
            ), HttpStatus.OK
        )
    }

    override fun createUser(createUser: com.example.api.controller.gen.CreateUser): ResponseEntity<User> {
        return ResponseEntity(
            User(
                userId = UUID.randomUUID(),
                userName = createUser.userName
            ), HttpStatus.OK
        )
    }
}