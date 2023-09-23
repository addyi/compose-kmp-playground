---
title: Gradle Version Catalog
description: Version centralization for dependencies with the Gradle version catalog.
---

# Gradle Version Catalog

The [Gradle version catalog](https://docs.gradle.org/current/userguide/platforms.html) is a feature that lets you centralize the
dependencies of your project in a single place. This can improve readability and maintainability of build scripts by reducing duplication of
dependency coordinates.

# Dependency Updates

There is a custom Gradle plugin in place to identify new versions of dependencies, update them, and format the version catalog. This plugin
extends and configures two Gradle plugins:

- [Ben Manes - gradle-version-plugin](https://github.com/ben-manes/gradle-versions-plugin)
- [littlerobots - version-catalog-update-plugin](https://github.com/littlerobots/version-catalog-update-plugin)

## Tasks

These plugins provide multiple convenient tasks:

### Formatting

To only format the version catalog file, use:

```shell
./gradlew versionCatalogFormat
```

### Interactive Update

To create a `libs.versions.updates.toml` file with the available versions of the dependencies, use:

```shell
./gradlew versionCatalogUpdate --interactive
```

Apply the changes to the version catalog file with:

```shell
./gradlew versionCatalogApplyUpdate
```

### Direct Update

To directly update all dependencies in the version catalog file, use:

```shell
./gradlew versionCatalogUpdate
```

These tasks make it easy to maintain and update the version catalog, ensuring your dependencies are always up to date.
