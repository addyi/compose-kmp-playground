---
title: Project Structure
description: Project Structure including shared, androidApp and iosApp modules
hide: [toc]
---

# Project Structure

!!! info
    This documentation is a copy of the [Jetpack Compose Multiplatform documentation][officialDoc].

[officialDoc]: https://github.com/JetBrains/compose-multiplatform-ios-android-template/#readme

Open the project in Android Studio and switch the view from **Android** to **Project** to see all the files and targets belonging to the
project.

Your Compose Multiplatform project includes 3 modules:

## shared

This is a Kotlin module that contains the logic common for both Android and iOS applications, that is, the code you share between platforms.

This `shared` module is also where you’ll write your Compose Multiplatform code.
In `shared/src/commonMain/kotlin/App.kt`, you can find the shared root `@Composable` function for your app.

It uses Gradle as the build system. You can add dependencies and change settings in `shared/build.gradle.kts`.
The `shared` module builds into an Android library and an iOS framework.

## androidApp

This is a Kotlin module that builds into an Android application. It uses Gradle as the build system.
The `androidApp` module depends on and uses the `shared` module as a regular Android library.

## iosApp

This is an Xcode project that builds into an iOS application.
It depends on and uses the `shared` module as a CocoaPods dependency.

