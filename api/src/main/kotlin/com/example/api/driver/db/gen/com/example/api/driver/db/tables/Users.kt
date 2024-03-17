/*
 * This file is generated by jOOQ.
 */
package com.example.api.driver.db.tables


import com.example.api.driver.db.Public
import com.example.api.driver.db.keys.USERS_PKEY
import com.example.api.driver.db.tables.records.UsersRecord

import java.time.LocalDateTime
import java.util.UUID

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Users(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UsersRecord>?,
    aliased: Table<UsersRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UsersRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.users</code>
         */
        val USERS: Users = Users()
    }

    /**
     * The class holding records for this type
     */
    public override fun getRecordType(): Class<UsersRecord> = UsersRecord::class.java

    /**
     * The column <code>public.users.user_id</code>.
     */
    val USER_ID: TableField<UsersRecord, UUID?> = createField(DSL.name("user_id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.users.created_at</code>.
     */
    val CREATED_AT: TableField<UsersRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UsersRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UsersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.users</code> table reference
     */
    constructor(): this(DSL.name("users"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UsersRecord>): this(Internal.createPathAlias(child, key), child, key, USERS, null)
    public override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    public override fun getPrimaryKey(): UniqueKey<UsersRecord> = USERS_PKEY
    public override fun `as`(alias: String): Users = Users(DSL.name(alias), this)
    public override fun `as`(alias: Name): Users = Users(alias, this)
    public override fun `as`(alias: Table<*>): Users = Users(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    public override fun rename(name: String): Users = Users(DSL.name(name), null)

    /**
     * Rename this table
     */
    public override fun rename(name: Name): Users = Users(name, null)

    /**
     * Rename this table
     */
    public override fun rename(name: Table<*>): Users = Users(name.getQualifiedName(), null)
}