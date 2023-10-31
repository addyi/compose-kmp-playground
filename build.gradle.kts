plugins {
    // this is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    alias(libs.plugins.jetbrains.kotlin.multiplatform).apply(false)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization).apply(false)
    id("dependency-version-management")
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
