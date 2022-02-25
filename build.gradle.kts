import Version.Kotlin
import Version.Ktor
import Version.Logback

plugins {
    application
    kotlin("jvm") version Version.Kotlin
    id("com.github.johnrengelman.shadow") version Version.ShadowJar
    id("org.jetbrains.kotlin.plugin.serialization") version Version.Kotlin
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
    implementation("ch.qos.logback:logback-classic:$Logback")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$Ktor")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$Ktor")
    implementation("io.ktor:ktor-server-core-jvm:$Ktor")
    implementation("io.ktor:ktor-server-host-common-jvm:$Ktor")
    implementation("io.ktor:ktor-server-netty-jvm:$Ktor")
    implementation("io.ktor:ktor-server-status-pages-jvm:$Ktor")

    testImplementation("io.ktor:ktor-server-tests-jvm:$Ktor")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$Kotlin")
}
