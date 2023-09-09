import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.jvm.get()))
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = libs.versions.java.jvm.get()
    }
}

dependencies {
    implementation(libs.plugin.version.management.version.catalog)
    implementation(libs.plugin.version.management.ben.manes)
}

dependencyLocking {
    lockAllConfigurations()
    lockMode.set(LockMode.STRICT)
    lockFile.set(rootProject.file("gradle/dependency-locks/${project.name}.gradle.lockfile"))
}
