plugins {
    // this is necessary to avoid the plugins to be loaded multiple times in each subproject's classloader
    alias(libs.plugins.com.android.application).apply(false)
    alias(libs.plugins.com.android.library).apply(false)
    alias(libs.plugins.org.jetbrains.compose).apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform).apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
