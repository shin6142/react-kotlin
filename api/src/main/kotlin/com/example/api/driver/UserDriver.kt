package com.example.api.driver

import com.example.api.driver.db.tables.records.UserDetailsRecord
import com.example.api.driver.db.tables.references.USER_DETAILS
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.List

@Component
class UserDriver(private val defaultDSLContext: DSLContext) {

    fun fetchUsers(): List<UserDetailsRecord> {
        return defaultDSLContext.select().from(USER_DETAILS)
            .fetchInto(UserDetailsRecord::class.java)
    }

    fun fetchUser(userId: UUID): UserDetailsRecord? {
        return defaultDSLContext.select().from(USER_DETAILS)
            .where(USER_DETAILS.USER_ID.eq(userId))
            .fetchOneInto(UserDetailsRecord::class.java)
    }
}