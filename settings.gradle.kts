rootProject.name = "com.example.ktorden"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("detektVersion", "1.19.0")
            version("kotlinVersion", "1.6.10")
            version("ktlintVersion", "10.2.1")
            version("ktorVersion", "2.0.0-beta-1")
            version("logbackVersion", "1.2.10")
            version("shadowVersion", "7.1.2")

            library("kotlin-test-junit", "org.jetbrains.kotlin", "kotlin-test-junit").versionRef("kotlinVersion")
            library(
                "ktor-serialization-kotlinx-json",
                "io.ktor",
                "ktor-serialization-kotlinx-json-jvm"
            ).versionRef("ktorVersion")
            library(
                "ktor-server-content-negotiation",
                "io.ktor",
                "ktor-server-content-negotiation-jvm"
            ).versionRef("ktorVersion")
            library("ktor-server-core", "io.ktor", "ktor-server-core-jvm").versionRef("ktorVersion")
            library("ktor-server-host-common", "io.ktor", "ktor-server-host-common-jvm").versionRef("ktorVersion")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty-jvm").versionRef("ktorVersion")
            library("ktor-server-status-pages", "io.ktor", "ktor-server-status-pages-jvm").versionRef("ktorVersion")
            library("ktor-server-tests", "io.ktor", "ktor-server-tests-jvm").versionRef("ktorVersion")
            library("logback", "ch.qos.logback", "logback-classic").versionRef("logbackVersion")

            plugin("detekt", "io.gitlab.arturbosch.detekt").versionRef("detektVersion")
            plugin("kotlin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlinVersion")
            plugin("ktlint", "org.jlleitschuh.gradle.ktlint").versionRef("ktlintVersion")
            plugin("shadow", "com.github.johnrengelman.shadow").versionRef("shadowVersion")
        }
    }
}
