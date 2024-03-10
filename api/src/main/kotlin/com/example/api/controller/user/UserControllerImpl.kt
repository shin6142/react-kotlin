package com.example.api.controller.user

import com.example.api.controller.gen.User
import com.example.api.controller.gen.UserApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserControllerImpl() : UserApi {
    override fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(
            listOf(
                User(
                    userId = UUID.randomUUID(),
                    userName = "Hugh"
                ),
                User(
                    userId = UUID.randomUUID(),
                    userName = "Rodrigo"
                ),
                User(
                    userId = UUID.randomUUID(),
                    userName = "Amanda"
                ),
                User(
                    userId = UUID.randomUUID(),
                    userName = "Oscar"
                ),
                User(
                    userId = UUID.randomUUID(),
                    userName = "Ibrahim"
                ),
            ), HttpStatus.OK
        )
    }

    override fun getUser(userId: UUID): ResponseEntity<User> {
        return ResponseEntity(
            User(
                userId = userId,
                userName = "User Name"
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