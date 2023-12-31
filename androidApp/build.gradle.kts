plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
    namespace = "com.myapplication"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.myapplication.MyApplication"
        minSdk = libs.versions.android.sdk.min.get().toInt()
        targetSdk = libs.versions.android.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.jvm.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.jvm.get())
    }

    kotlin {
        jvmToolchain(libs.versions.java.jvm.get().toInt())
    }
}

dependencyLocking {
    lockAllConfigurations()
    lockFile.set(rootProject.file("gradle/dependency-locks/${project.name}.gradle.lockfile"))
}
