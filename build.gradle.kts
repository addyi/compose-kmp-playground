plugins {
    // this is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    alias(libs.plugins.jetbrains.kotlin.multiplatform).apply(false)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization).apply(false)
    alias(libs.plugins.arturbosch.detekt)
    id("dependency-version-management")
}

detekt {
    // Documentation: https://detekt.dev/gradle.html#options-for-detekt-configuration-closure

    source = files("androidApp", "shared") // The directories where detekt looks for source files.

    config = files("${rootProject.rootDir}/detekt.yml")

    parallel = true // Builds the AST in parallel.

//    ignoredBuildTypes = listOf("release") // Don't create tasks for the specified build types (e.g. "release")
//    ignoredFlavors = listOf("production", "staging") // Don't create tasks for the specified build flavor (e.g. "production")
//    ignoredVariants = listOf("productionRelease") // Don't create tasks for the specified build variants (e.g. "productionRelease")

    basePath = projectDir.absolutePath

    allRules = true // Turns on all the rules. Default: false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    delete(rootProject.projectDir.resolve("buildSrc/build"))
    delete(rootProject.projectDir.resolve("iosApp/iosApp.xcworkspace")) // This might delete advanced configuration files. see ios-config.md
    delete(rootProject.projectDir.resolve("iosApp/Pods"))
    delete(rootProject.projectDir.resolve("iosApp/iosApp.xcodeproj/project.xcworkspace"))
    delete(rootProject.projectDir.resolve("iosApp/iosApp.xcodeproj/xcuserdata"))
}

dependencyLocking {
    lockAllConfigurations()
    lockFile.set(rootProject.file("gradle/dependency-locks/${project.name}.gradle.lockfile"))
}
