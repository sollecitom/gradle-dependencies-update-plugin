# kotlin-gradle-plugin-template 🐘

## How to use 👣

Once cloned, remember to update:

- [gradle.properties](plugin-build/gradle.properties)
- Plugin Usages (search for org.sollecitom.kotlin.gradle.versions in the repo and replace it with your ID).

## Composite Build 📦

This template is using a [Gradle composite build](https://docs.gradle.org/current/userguide/composite_builds.html) to build, test and publish the plugin. This means that you don't need to run Gradle twice to test the changes on your Gradle plugin (no more `publishToMavenLocal` tricks or so).

The included build is inside the [plugin-build](plugin-build) folder.

If you need to invoke a task inside the included build with:

```shell
./gradlew -p plugin-build <task-name>
```

To build everything (until a better solution is found):

```shell
./gradlew build && ./gradlew -p plugin-build build && ./gradlew -p example build
```

### Dependency substitution

Please note that the project relies on module name/group in order for [dependency substitution](https://docs.gradle.org/current/userguide/resolution_rules.html#sec:dependency_substitution_rules) to work properly. If you change only the plugin ID everything will work as expected. If you change module name/group, things might break, and you probably have to specify a [substitution rule](https://docs.gradle.org/current/userguide/resolution_rules.html#sub:project_to_module_substitution).

## Publishing 🚀

This template is ready to let you publish to [Gradle Portal](https://plugins.gradle.org/).

The [![Publish Plugin to Portal](https://github.com/cortinico/kotlin-gradle-plugin-template/workflows/Publish%20Plugin%20to%20Portal/badge.svg?branch=1.0.0)](https://github.com/cortinico/kotlin-gradle-plugin-template/actions?query=workflow%3A%22Publish+Plugin+to+Portal%22) Github Action will take care of the publishing whenever you **push a tag**.

Please note that you need to configure two secrets: `GRADLE_PUBLISH_KEY` and `GRADLE_PUBLISH_SECRET` with the credentials you can get from your profile on the Gradle Portal.

## CI ⚙️

This template is using [**GitHub Actions**](https://github.com/cortinico/kotlin-android-template/actions) as CI. You don't need to set up any external service, and you should have a running CI once you start using this template.

There are currently the following workflows available:

- [Validate Gradle Wrapper](.github/workflows/gradle-wrapper-validation.yml) - Will check that the Gradle wrapper has a valid checksum
- [Publish to Plugin Portal](.github/workflows/publish-plugin.yaml) - Will run the `publishPlugin` task when pushing a new tag.
