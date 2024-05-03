package com.example.api.controller.user

import com.example.api.controller.gen.CreateUser
import com.example.api.controller.gen.User
import com.example.api.controller.gen.UserApi
import com.example.api.driver.UserDriver
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
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

    override fun createUser(createUser: CreateUser): ResponseEntity<User> {
        val userId = UUID.randomUUID()
        userDriver.insertUser(userId, LocalDateTime.now())
        userDriver.insertUserDetail(userId, createUser.userName)
        return ResponseEntity(
            User(
                userId = UUID.randomUUID(),
                userName = createUser.userName
            ), HttpStatus.CREATED
        )
    }

    override fun updateUser(userId: UUID, user: User): ResponseEntity<User> {
        val targetRecord = userDriver.fetchUser(userId) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val id = targetRecord.userId ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        val userName = targetRecord.username ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(
            User(
                userId = id,
                userName = user.userName
            ), HttpStatus.CREATED
        )
    }
}