import Version.Kotlin
import Version.Ktor
import Version.Logback
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    application
    kotlin("jvm") version Version.Kotlin
    id("com.github.johnrengelman.shadow") version Version.ShadowJar
    id("io.gitlab.arturbosch.detekt") version Version.Detekt
    id("org.jetbrains.kotlin.plugin.serialization") version Version.Kotlin
    id("org.jlleitschuh.gradle.ktlint") version Version.KtLint
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(libs.logback)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.status.pages)

    testImplementation(libs.ktor.server.tests)
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$Kotlin")
}

tasks {
    @Suppress("UnusedPrivateMember")
    val detektCheck by registering(Detekt::class) {
        parallel = true
        ignoreFailures = true
        setSource(files(projectDir))
        include("**/*.kt")
        include("**/*.kts")
        exclude("**/resources/**")
        exclude("**/build/**")
    }
}
