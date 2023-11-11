---
title: BuildConfig, environment variables and secrets
description: How are environment variables and secrets configured in the app?
hide: [toc]
---

# BuildConfig, environment variables and secrets

The android concept of a BuildConfig is not applicable for Kotlin Multiplatform. The [BuildKonfig](https://github.com/yshrsmz/BuildKonfig)
gradle plugin helps here to generate a BuildConfig that can be used by all platforms. It is used in this project to inject secrets and
environment variables into the app.

Example of a generated `BuildKonfig`:

```kotlin
internal object BuildKonfig {
  public val apodHost: String = "api.nasa.gov"

  public val apodApiKey: String = "DEMO_KEY"
}
```
