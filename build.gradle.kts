plugins {
    // this is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    alias(libs.plugins.jetbrains.kotlin.multiplatform).apply(false)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization).apply(false)
    alias(libs.plugins.detekt)
    id("dependency-version-management")
}

detekt {
    // Documentation: https://detekt.dev/docs/gettingstarted/gradle/#kotlin-dsl-3

    source.setFrom(".", "androidApp", "shared") // The directories where detekt looks for source files.

    buildUponDefaultConfig = true // Applies the config files on top of detekt's default config file. `false` by default.
    config.setFrom("${rootProject.rootDir}/detekt.yml")

    parallel = true // Builds the AST in parallel.

    baseline = file("${rootProject.rootDir}/detekt-baseline.xml") // TODO get rid of baseline as fast as possible

    basePath = projectDir.absolutePath

    allRules = true // Turns on all the rules. Default: false
}

dependencies {
    detektPlugins(libs.detekt.rules.compose.kode)
    detektPlugins(libs.detekt.rules.compose.nlopez)
    detektPlugins(libs.detekt.rules.formatting.ktlint)
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
