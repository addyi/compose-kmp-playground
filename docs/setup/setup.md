---
title: Environment Setup
description: Prerequisites and setup for the development environment
icon: material/package-down
hide: [toc]
---

# Environment Setup

!!! info
    This documentation is a copy of the [Jetpack Compose Multiplatform documentation][officialDoc].

[officialDoc]: https://github.com/JetBrains/compose-multiplatform-ios-android-template/#readme


## Prerequisites

!!! warning
    You need a Mac with macOS to write and run iOS-specific code on simulated or real devices.
    This is an Apple requirement.

To work with Compose Multiplatform, you need the following:

- A machine running a recent version of macOS
- Xcode
- Android Studio
    - The [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
    - AS plugin: Compose Multiplatform IDE Support (doesn't hurt)
    - AS plugin: SQLDelight (doesn't hurt)
- The [CocoaPods dependency manager](https://kotlinlang.org/docs/native-cocoapods.html)

!!! note
    So far cocoa pods was not needed for this project. Cocoapods requires ruby and ruby has a bit more complicated setup on apple silicon
    macs. KDoctor helps with the installation.

### Environment Check - KDoctor

With the [KDoctor](https://github.com/Kotlin/kdoctor) tool, you can check whether your development environment is configured correctly.

1. Install KDoctor with [Homebrew](https://brew.sh/):

    ```shell
    brew install kdoctor
    ```

2. Run KDoctor in your terminal:

    ```shell
    kdoctor
    ```

   If everything is set up correctly, you'll see valid output:

   ```
   Environment diagnose (to see all details, use -v option):
   [✓] Operation System
   [✓] Java
   [✓] Android Studio
   [✓] Xcode
   [✓] Cocoapods

   Conclusion:
     ✓ Your system is ready for Kotlin Multiplatform Mobile development!
   ```

Otherwise, KDoctor will highlight which parts of your setup still need to be configured and will suggest a way to fix them.


