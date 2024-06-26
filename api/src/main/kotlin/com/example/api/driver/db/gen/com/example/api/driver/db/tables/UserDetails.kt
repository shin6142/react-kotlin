/*
 * This file is generated by jOOQ.
 */
package com.example.api.driver.db.tables


import com.example.api.driver.db.Public
import com.example.api.driver.db.keys.USER_DETAILS_PKEY
import com.example.api.driver.db.keys.USER_DETAILS__USER_DETAILS_USER_ID_FKEY
import com.example.api.driver.db.tables.records.UserDetailsRecord

import java.util.UUID

import kotlin.collections.List

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
open class UserDetails(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UserDetailsRecord>?,
    aliased: Table<UserDetailsRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UserDetailsRecord>(
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
         * The reference instance of <code>public.user_details</code>
         */
        val USER_DETAILS: UserDetails = UserDetails()
    }

    /**
     * The class holding records for this type
     */
    public override fun getRecordType(): Class<UserDetailsRecord> = UserDetailsRecord::class.java

    /**
     * The column <code>public.user_details.user_id</code>.
     */
    val USER_ID: TableField<UserDetailsRecord, UUID?> = createField(DSL.name("user_id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.user_details.username</code>.
     */
    val USERNAME: TableField<UserDetailsRecord, String?> = createField(DSL.name("username"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UserDetailsRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UserDetailsRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.user_details</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.user_details</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.user_details</code> table reference
     */
    constructor(): this(DSL.name("user_details"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UserDetailsRecord>): this(Internal.createPathAlias(child, key), child, key, USER_DETAILS, null)
    public override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    public override fun getPrimaryKey(): UniqueKey<UserDetailsRecord> = USER_DETAILS_PKEY
    public override fun getReferences(): List<ForeignKey<UserDetailsRecord, *>> = listOf(USER_DETAILS__USER_DETAILS_USER_ID_FKEY)

    private lateinit var _users: Users

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    fun users(): Users {
        if (!this::_users.isInitialized)
            _users = Users(this, USER_DETAILS__USER_DETAILS_USER_ID_FKEY)

        return _users;
    }

    val users: Users
        get(): Users = users()
    public override fun `as`(alias: String): UserDetails = UserDetails(DSL.name(alias), this)
    public override fun `as`(alias: Name): UserDetails = UserDetails(alias, this)
    public override fun `as`(alias: Table<*>): UserDetails = UserDetails(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    public override fun rename(name: String): UserDetails = UserDetails(DSL.name(name), null)

    /**
     * Rename this table
     */
    public override fun rename(name: Name): UserDetails = UserDetails(name, null)

    /**
     * Rename this table
     */
    public override fun rename(name: Table<*>): UserDetails = UserDetails(name.getQualifiedName(), null)
}
