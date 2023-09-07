# Dependency version management

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
