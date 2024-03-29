/*
 * This file is generated by jOOQ.
 */
package com.example.api.driver.db


import com.example.api.driver.db.tables.Databasechangelog
import com.example.api.driver.db.tables.Databasechangeloglock
import com.example.api.driver.db.tables.UserDetails
import com.example.api.driver.db.tables.Users

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Public : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC: Public = Public()
    }

    /**
     * The table <code>public.databasechangelog</code>.
     */
    val DATABASECHANGELOG: Databasechangelog get() = Databasechangelog.DATABASECHANGELOG

    /**
     * The table <code>public.databasechangeloglock</code>.
     */
    val DATABASECHANGELOGLOCK: Databasechangeloglock get() = Databasechangeloglock.DATABASECHANGELOGLOCK

    /**
     * The table <code>public.user_details</code>.
     */
    val USER_DETAILS: UserDetails get() = UserDetails.USER_DETAILS

    /**
     * The table <code>public.users</code>.
     */
    val USERS: Users get() = Users.USERS

    public override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    public override fun getTables(): List<Table<*>> = listOf(
        Databasechangelog.DATABASECHANGELOG,
        Databasechangeloglock.DATABASECHANGELOGLOCK,
        UserDetails.USER_DETAILS,
        Users.USERS
    )
}
