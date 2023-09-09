# Dependency Locking

Dependencies are locked. This means that the version of the dependencies are fixed and can not be changed by the gradle dependency
resolution. see [Gradle Dependency Locking](https://docs.gradle.org/current/userguide/dependency_locking.html)

There is a shell scrip that can unlock the dependencies if a dependency needs to be updated. (see `./scripts/unlock_gradle_dependencies`)

That the `settings-gradle.lockfile` is generated seems to be a bug: <https://github.com/gradle/gradle/issues/21101>
