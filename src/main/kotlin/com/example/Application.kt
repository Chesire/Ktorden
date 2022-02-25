package com.example

import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.Application

/**
 * Kotlin main method - starts the Ktor engine.
 * After running in IDEA this should be available at localhost:8080.
 */
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

/**
 * Ktor [module], will configure the ktor client.
 */
@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureRouting()
}
