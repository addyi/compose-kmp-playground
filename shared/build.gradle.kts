import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.serialization.json)
                implementation(libs.jetbrains.kotlinx.datetime)
                // TODO implementation(libs.coil.compose) Use when KMP is supported https://github.com/coil-kt/coil/issues/842#issuecomment-1622516075
                implementation(libs.arrow.core)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.androidx.activity.compose)
                api(libs.androidx.appcompat)
                api(libs.androidx.core.ktx)
                api(libs.ktor.client.android)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
    }
}

android {
    compileSdk = libs.versions.android.sdk.compile.get().toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.android.sdk.min.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.jvm.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.jvm.get())
    }

    kotlin {
        jvmToolchain(libs.versions.java.jvm.get().toInt())
    }
}

buildkonfig {
    packageName = "io.github.addyi.playground"

    val apodApiKey = System.getenv("APOD_API_KEY")
        ?: extra.properties.getOrDefault("apodApiKey", null) as? String
        ?: throw GradleException("Please define your APOD API KEY as described in README")

    defaultConfigs {
        buildConfigField(STRING, "apodHost", "api.nasa.gov")
        buildConfigField(STRING, "apodApiKey", apodApiKey)
    }
}

dependencyLocking {
    lockAllConfigurations()
    lockFile.set(rootProject.file("gradle/dependency-locks/${project.name}.gradle.lockfile"))
}
