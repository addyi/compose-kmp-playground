---
title: Project Tooling
description: A variety of tools that are used to streamline the development process, maintain code quality, and ensure consistency.
---

# Project Tooling Overview

This project incorporates a variety of tools streamline the development process, maintaining code quality, and ensuring consistency.

## Documentation

[MkDocs](documentation.md), a static site generator, is used for creating and maintaining the project's documentation. It transforms
Markdown files into a user-friendly HTML website.

## Linting

[Linting](linting.md) is implemented to enforce code quality and consistency across the project. It aids in detecting errors, enforcing code
conventions, and preventing potential bugs.

## Continuous Integration (CI)

GitHub Actions are used for [Continuous Integration](ci.md), which includes building the application and deploying the documentation
website. This ensures seamless integration of changes into the existing codebase and keeps the live documentation updated.

## Dependency Management

The project utilizes Gradle's dependency locking and version catalog for [managing dependencies](dependencies/index.md), ensuring consistent
versions and preventing unintentional updates. A custom setup is also in place which identifies new versions of dependencies, updates them,
and formats the version catalog.

