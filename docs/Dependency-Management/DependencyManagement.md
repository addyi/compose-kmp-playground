# Dependency Updates

There is a custom gradle plugin that can be used to identify new versions of dependencies, update them also format the version catalog.

For this two gradle plugins are extended and configured:

- [Ben Manes - gradle-version-plugin](https://github.com/ben-manes/gradle-versions-plugin)
- [littlerobots - version-catalog-update-plugin](https://github.com/littlerobots/version-catalog-update-plugin)

## Tasks

The version catalog plugin provides multiple convenient tasks.

### Formatting
Only format the version catalog file

```shell
./gradlew versionCatalogFormat
```

### Interactive Update


Create a `libs.versions.updates.toml` file with the available versions of the dependencies.

```shell
./gradlew versionCatalogUpdate --interactive
```

Apply the changes to the version catalog file.

```shell
./gradlew versionCatalogApplyUpdate
```

### Direct Update

Directly update all dependencies in the version catalog file.

```shell
./gradlew versionCatalogUpdate
```

