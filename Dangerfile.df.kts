/*
 * Use external dependencies using the following annotations:
 */
@file:Repository("https://repo.maven.apache.org")
@file:DependsOn("org.apache.commons:commons-text:1.6")
@file:DependsOn("io.github.ackeecz:danger-kotlin-detekt:0.1.4")

import io.github.ackeecz.danger.detekt.DetektPlugin
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.BiPredicate
import java.util.stream.Collectors
import systems.danger.kotlin.*

register plugin DetektPlugin

danger(args) {
    val allSourceFiles = git.modifiedFiles + git.createdFiles
    val sourceChanges = allSourceFiles.firstOrNull { it.contains("src") }

    onGitHub {
        // Big PR Check
        if ((pullRequest.additions ?: 0) - (pullRequest.deletions ?: 0) > 500) {
            warn("Big PR, try to keep changes smaller if you can")
        }

        // Work in progress check
        if (pullRequest.title.contains("WIP", false)) {
            warn("PR is classed as Work in Progress")
        }

        // Ensure title is provided
        if (pullRequest.title.length < 5) {
            failure("Please provide a title for the pull request")
        }

        // Ensure body is provided
        if (pullRequest.body.length < 5) {
            failure(Please provide a description for the pull request")
        }
    }

    val detektReports = Files
        .find(
            Paths.get(""),
            10,
            BiPredicate { path, attributes ->
                val fileName = path.toFile().name
                fileName.endsWith("detekt.xml")
            }
        ).map { it.toFile() }
        .collect(Collectors.toList())

    DetektPlugin.parseAndReport(*detektReports.toTypedArray())
}
