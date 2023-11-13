package org.sollecitom.kotlin.gradle.versions.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

abstract class TemplateExampleTask : DefaultTask() {

    init {
        description = "Just a sample template task"

        // Don't forget to set the group here.
        // group = BasePlugin.BUILD_GROUP
    }

    @get:Input
    @get:Option(option = "checkConstraints", description = "A flag to enforce version constraints checks. Default is true.")
    @get:Optional
    abstract val checkConstraints: Property<Boolean>

    @get:Input
    @get:Option(option = "checkBuildEnvironmentConstraints", description = "A flag to check environment constraints. Default is false.")
    @get:Optional
    abstract val checkBuildEnvironmentConstraints: Property<Boolean>

    @get:Input
    @get:Option(option = "checkForGradleUpdate", description = "A flag to check whether a new version of Gradle is available. Default is true.")
    @get:Optional
    abstract val checkForGradleUpdate: Property<Boolean>



    @get:Input
    @get:Option(option = "message", description = "A message to be printed in the output file")
    abstract val message: Property<String>

    @get:Input
    @get:Option(option = "tag", description = "A Tag to be used for debug and in the output file")
    @get:Optional
    abstract val tag: Property<String>

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @TaskAction
    fun sampleAction() {
        val prettyTag = tag.orNull?.let { "[$it]" } ?: ""

        logger.lifecycle("$prettyTag message is: ${message.orNull}")
        logger.lifecycle("$prettyTag tag is: ${tag.orNull}")
        logger.lifecycle("$prettyTag outputFile is: ${outputFile.orNull}")

        outputFile.get().asFile.writeText("$prettyTag ${message.get()}")
    }
}
