---
title: Project Documentation
description: Project documentation with MkDocs and Material theme
icon: logo
---

# Project Documentation

This project documentation is created using [MkDocs](https://www.mkdocs.org/), a static site generator that turns Markdown files into a
user-friendly HTML website.

I've have chosen the [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) theme, enhancing our documentation's aesthetics and
usability. This theme incorporates features such as a searchable site, responsive layouts, customizable navigation, and a dark mode,
striving to deliver an optimal user experience.

## Project layout

```
mkdocs.yml    # The configuration file.
docs/         # The documentation directory.
```

## Publishing

There is a GitHub action that automatically publishes the website. For local testing and review, install MkDocs on your local machine.

## Local installation

**Pre-requisites**: Python 3.6 or higher and pip.

Nice tutorial for installation: <https://youtu.be/Q-YA_dA8C20>

Set up a virtual python environment and install MkDocs Material theme:

```shell
python3 -m venv venv
pip3 install mkdocs-material pillow cairosvg

```

### Commands

* `mkdocs serve` - Start the live-reloading docs server. Needs a virtual environment.
* `mkdocs build` - Build the documentation site.
* `mkdocs -h` - Print help message and exit.
* `mkdocs new .` - Create a new project in the current directory.

## Page customization

```yaml
---
title: Welcome
description: Welcome to the Compose Kotlin Multiplatform Playground
icon: simple/jetpackcompose
hide: [ navigation, toc ]
---
```
