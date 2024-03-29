/*
 * This file is generated by jOOQ.
 */
package com.example.api.driver.db.tables


import com.example.api.driver.db.Public
import com.example.api.driver.db.tables.records.DatabasechangelogRecord

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Databasechangelog(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, DatabasechangelogRecord>?,
    aliased: Table<DatabasechangelogRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<DatabasechangelogRecord>(
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
         * The reference instance of <code>public.databasechangelog</code>
         */
        val DATABASECHANGELOG: Databasechangelog = Databasechangelog()
    }

    /**
     * The class holding records for this type
     */
    public override fun getRecordType(): Class<DatabasechangelogRecord> = DatabasechangelogRecord::class.java

    /**
     * The column <code>public.databasechangelog.id</code>.
     */
    val ID: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("id"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.author</code>.
     */
    val AUTHOR: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("author"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.filename</code>.
     */
    val FILENAME: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("filename"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.dateexecuted</code>.
     */
    val DATEEXECUTED: TableField<DatabasechangelogRecord, LocalDateTime?> = createField(DSL.name("dateexecuted"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.orderexecuted</code>.
     */
    val ORDEREXECUTED: TableField<DatabasechangelogRecord, Int?> = createField(DSL.name("orderexecuted"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.exectype</code>.
     */
    val EXECTYPE: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("exectype"), SQLDataType.VARCHAR(10).nullable(false), this, "")

    /**
     * The column <code>public.databasechangelog.md5sum</code>.
     */
    val MD5SUM: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("md5sum"), SQLDataType.VARCHAR(35), this, "")

    /**
     * The column <code>public.databasechangelog.description</code>.
     */
    val DESCRIPTION: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("description"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.databasechangelog.comments</code>.
     */
    val COMMENTS: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("comments"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.databasechangelog.tag</code>.
     */
    val TAG: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("tag"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.databasechangelog.liquibase</code>.
     */
    val LIQUIBASE: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("liquibase"), SQLDataType.VARCHAR(20), this, "")

    /**
     * The column <code>public.databasechangelog.contexts</code>.
     */
    val CONTEXTS: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("contexts"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.databasechangelog.labels</code>.
     */
    val LABELS: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("labels"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.databasechangelog.deployment_id</code>.
     */
    val DEPLOYMENT_ID: TableField<DatabasechangelogRecord, String?> = createField(DSL.name("deployment_id"), SQLDataType.VARCHAR(10), this, "")

    private constructor(alias: Name, aliased: Table<DatabasechangelogRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<DatabasechangelogRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.databasechangelog</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.databasechangelog</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.databasechangelog</code> table reference
     */
    constructor(): this(DSL.name("databasechangelog"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, DatabasechangelogRecord>): this(Internal.createPathAlias(child, key), child, key, DATABASECHANGELOG, null)
    public override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    public override fun `as`(alias: String): Databasechangelog = Databasechangelog(DSL.name(alias), this)
    public override fun `as`(alias: Name): Databasechangelog = Databasechangelog(alias, this)
    public override fun `as`(alias: Table<*>): Databasechangelog = Databasechangelog(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    public override fun rename(name: String): Databasechangelog = Databasechangelog(DSL.name(name), null)

    /**
     * Rename this table
     */
    public override fun rename(name: Name): Databasechangelog = Databasechangelog(name, null)

    /**
     * Rename this table
     */
    public override fun rename(name: Table<*>): Databasechangelog = Databasechangelog(name.getQualifiedName(), null)
}
