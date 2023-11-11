---
title: Linting
description: Linting with detekt and ktlint
---

# Linting

:construction: Plan is to set up a [detekt](https://detekt.dev/) and [ktlint](https://github.com/JLLeitschuh/ktlint-gradle) integration with
gradle.

## Detekt

Linting is currently set up with [detekt](https://detekt.github.io/detekt/). The configuration is located in `detekt.yml`.

Current issue is the set up of a convention plugin that can be applied to all modules. The current solution is to apply the plugin to the
root project and run it on all files in the project. This is not ideal as it will run on all files in the project, including the build
files. Therefor an exclusion for the `build` folder was added. Also detekt doesn't run with type resolution, which means that it can't find
deeper issues related to the codebase. Have another go at it when detekt 2.0 is released. This should then have official support for type
resolution.

### Updating detekt

1. Update detekt in `libs.versions.toml`
2. Delete `detekt.yml` in the root project
3. Run `./gradlew detektGenerateConfig` in the root project
4. Check the git diff for changes of the default detekt config

More information about updating detekt can be found in the blog post: [Recipe: diff your detekt config with the default one][detektDiff].


[detektDiff]: https://detekt.dev/blog/2020/09/27/additional-diff-config-task/

### Running detekt during compile time

> You can integrate detekt in your project using the Detekt **Compiler** Plugin instead of the classic Detekt Gradle Plugin. Detekt offers a
> compiler plugin for K1 which allows you to run detekt as part of the Kotlin compilation process. This allows you to run detekt on your code
> without having separate tasks to invoke and results in much faster execution of detekt, especially if you're using type resolution.

Source: https://detekt.dev/docs/gettingstarted/compilerplugin
