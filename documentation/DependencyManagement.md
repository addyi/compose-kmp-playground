# Dependency Version management

There is a custom gradle plugin that is used to manage the versions of the dependencies and the formatting of the version catalog.

For this two gradle plugins are extended and configured:

- https://github.com/ben-manes/gradle-versions-plugin
- https://github.com/littlerobots/version-catalog-update-plugin

## Tasks

```shell
./gradlew versionCatalogFormat # Only format the version catalog file
```

```shell
./gradlew versionCatalogUpdate --interactive # Create a "libs.versions.updates.toml" file with the available versions of the dependencies.
./gradlew versionCatalogApplyUpdate # Apply the changes to the version catalog file.
```

```shell
./gradlew versionCatalogUpdate # Directly update all dependencies in the version catalog file.
```

# Dependency locking

Dependencies are locked. This means that the version of the dependencies are fixed and can not be changed by the gradle dependency
resolution.

https://docs.gradle.org/current/userguide/dependency_locking.html

There is a shell scrip that can unlock the dependencies if a dependency needs to be updated. (see `./scripts/unlock_gradle_dependencies`)

That the settings-gradle.lockfile is generated seems to be a bug: https://github.com/gradle/gradle/issues/21101
