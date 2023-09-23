---
title: Gradle Dependency Locking
description: Dependency locking for more control of dependency versions.
---

# Gradle Dependency Locking

## Overview

Gradle dependency locking is a feature that ensures the version of project dependencies are fixed and cannot be changed by the Gradle
dependency resolution process. This mechanism aims to increase the reliability and consistency of the build process by preventing unexpected
changes in dependencies.

The application of Gradle dependency locking not only enforces the consistency of the build process but also provides a way to manage
dependencies in a more controlled manner.

More details about this feature can be found in the
official [Gradle Dependency Locking](https://docs.gradle.org/current/userguide/dependency_locking.html) documentation.

## Unlocking Dependencies

In certain scenarios, such as when a specific dependency needs to be updated, dependencies can be unlocked. To unlock the dependencies, a
provided shell script `./scripts/unlock_gradle_dependencies.sh` can be used.

Once a dependency is updated, the changes will be reflected in the git diff. This way, it is easy to track what has changed during the
update.

## Known Issues

Please note that the generation of a `settings-gradle.lockfile` appears to be a bug. More information on this issue can be found
here: [Gradle Issue #21101](https://github.com/gradle/gradle/issues/21101).
