package com.example.plugins.koin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.ext.Koin

/**
 * Installs and configures the [Koin] plugin.
 */
fun Application.configureKoin() {
    install(KoinPlugin) {
        modules()
    }
}
