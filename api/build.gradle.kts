import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

val dbHost = System.getenv("DB_MASTER_HOST") ?: "localhost"
val dbPort = System.getenv("DB_MASTER_PORT") ?: "15432"
val dbUser = System.getenv("DB_USER") ?: "root"
val dbPass = System.getenv("DB_PASS") ?: "root"
val dbName = System.getenv("DB_NAME") ?: "db"

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
                "logLevel" to "info",
                "changelogFile" to "/src/main/resources/liquibase/changelog.xml",
                "url" to "jdbc:postgresql://$dbHost:$dbPort/$dbName",
                "username" to dbUser,
                "password" to dbPass
        )
    }
}

jooq {
    version.set("3.18.2")
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("main") {
            jooqConfiguration.apply {
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
                    user = dbUser
                    password = dbPass
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                    }
                    target.apply {
                        packageName = "com.example.api.driver.db"
                        directory = "${project.rootDir}/src/main/kotlin/com/example/api/driver/db/gen"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("org.openapi.generator") version "7.3.0"
    id("org.liquibase.gradle") version  "2.2.0"
    id("nu.studer.jooq") version "9.0"
    kotlin("plugin.serialization") version "1.9.10"
    id("io.kotest.multiplatform") version "5.8.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    /**
     * liquibaseRuntime
     */
    implementation("org.liquibase:liquibase-core")
    liquibaseRuntime("info.picocli:picocli:4.7.1")
    runtimeOnly("org.postgresql:postgresql")
    liquibaseRuntime("org.liquibase:liquibase-core")
    liquibaseRuntime("org.postgresql:postgresql")
    /**
     * Swagger Annotations
     * Swagger Models
     * Jakarta Annotations API
     */
    compileOnly("io.swagger.core.v3:swagger-annotations:2.2.4")
    compileOnly("io.swagger.core.v3:swagger-models:2.2.4")
    compileOnly("jakarta.annotation:jakarta.annotation-api:2.1.1")
    /**
     * Spring Boot Starter Validation
     */
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("javax.validation:validation-api:2.0.1.Final")
    jooqGenerator("org.postgresql:postgresql:42.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    /**
     * kotest
     */
    val kotestVersion = "5.8.0"
    testImplementation("io.kotest:kotest-runner-junit5:${kotestVersion}")
    testImplementation("io.kotest:kotest-assertions-core:${kotestVersion}")
    testImplementation("io.kotest:kotest-property:${kotestVersion}")
    val kotestArrowVersion = "1.4.0"
    testImplementation("io.kotest.extensions:kotest-assertions-arrow:${kotestArrowVersion}")
    testImplementation("io.kotest.extensions:kotest-assertions-arrow-fx-coroutines:${kotestArrowVersion}")
    testImplementation("io.mockk:mockk:1.13.8")
    /**
     * Arrow kt
     */
    implementation("io.arrow-kt:arrow-core:1.2.0")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")
    /**
     * okhttp
     */
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    /**
     * csv
     */
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.2")
    /**
     * open api
     */
    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:1.7.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

/**
 * OpenAPI Generator を使って API ドキュメント生成
 */
task<GenerateTask>("generateApiDoc") {
    generatorName.set("html2")
    inputSpec.set("$projectDir/openapi.yaml")
    outputDir.set("$121324332buildDir/openapi/doc/")
}

/**
 * OpenAPI Generator を使ってコード生成
 */
task<GenerateTask>("generateApiServer") {
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/openapi.yaml")
    outputDir.set("$projectDir/src/main/kotlin/com/example/api/controller/gen")
    apiPackage.set("com.example.api.controller.gen")
    modelPackage.set("com.example.api.controller.gen")
    configOptions.set(
        mapOf(
            "interfaceOnly" to "true",
        )
    )
    /**
     * true にすると tags 準拠で、API の interface を生成する
     */
    additionalProperties.set(
        mapOf(
            "useTags" to "true"
        )
    )
}

/**
 * Kotlinをコンパイルする前に、generateApiServerタスクを実行
 * 必ずスキーマファイルから最新のコードが生成され、もし変更があったらコンパイル時に失敗して気付けるため
 */
tasks.compileKotlin {
    dependsOn("generateApiServer")
}