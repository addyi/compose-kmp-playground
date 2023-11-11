---
title: Linting
description: Linting with detekt and ktlint
---

# Linting

Adding linting to a code project, with tools like Detekt for Kotlin, is crucial for ensuring consistent coding styles, improving code
quality, and catching potential bugs early in the development process. Linting promotes collaboration within development teams by enforcing
uniform coding conventions, enhancing code readability, and automating the identification of common issues during code reviews. Detekt,
being Kotlin-specific, allows for customizable rules tailored to a project's needs, ensuring adherence to best practices and Kotlin-specific
coding conventions. This leads to increased productivity, seamless integration into CI/CD pipelines, and ultimately results in more
maintainable and reliable Kotlin projects.

:construction: Plan is to set up a [detekt](https://detekt.dev/) (done) and [ktlint](https://github.com/JLLeitschuh/ktlint-gradle) (todo)
integration with gradle.

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

### Plugins

Detekt has a plugin system to extend detekt with additional rulesets. The following plugins are currently used:

- <https://github.com/appKODE/detekt-rules-compose>
- <https://mrmans0n.github.io/compose-rules/>
- <https://detekt.dev/docs/next/rules/formatting/>
