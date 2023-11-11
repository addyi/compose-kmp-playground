---
title: Project environment variables
description: How to configure the project environment variables
---

# Environment variables

The following environment variables are used and required by the application.

## Apod API key

API key for the [NASA APOD API](https://api.nasa.gov/). For testing purposes, the key `DEMO_KEY` can be used.

Depending on preference the key can be defined as environment variable or in the `~/.gradle/gradle.properties` file.

**Properties file**:

```sh title="~/.gradle/gradle.properties"
apodApiKey = DEMO_KEY
```

**Environment variable**:

Define `APOD_API_KEY` as environment variable e.g. in `~/.bash_profile` or `~/.zprofile`:

```shell title="~/.zprofile"
export APOD_API_KEY="DEMO_KEY"
```
