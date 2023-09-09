# MkDocs & Material Theme

!!! info
    AI generated description

[MkDocs](https://www.mkdocs.org/) is a user-friendly, fast, and simple static site generator geared towards creating project documentation.
It facilitates the conversion of Markdown files into a navigable HTML website. With a variety of pre-made themes, MkDocs also supports
customization allowing developers to deploy aesthetically pleasing, intuitive websites directly from their codebase with minimal effort. One
notable theme for MkDocs is [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/), a sleek and modern skin designed using
Google's Material Design guidelines. Besides enhancing the visual appeal, the Material theme adds useful features like a searchable site,
responsive layouts, customizable navigation, language switching, dark mode, etc. This theme offers great rendering on various devices and
enriches the overall user experience. It also embodies the spirit of open-source collaboration.

## Pre-requisites

Nice tutorial for installation: <https://youtu.be/Q-YA_dA8C20>

- Python 3.6 or higher
- pip

## Installation

Set up a virtual environment install MkDocs Material theme and create a new project in current directory:

```shell
python3 -m venv venv
pip3 install mkdocs-material
mkdocs new .
```

## Project layout

    mkdocs.yml    # The configuration file.
    docs/
        index.md  # The documentation homepage.
        ...       # Other markdown pages, images and other files.

## Commands

* `mkdocs serve` - Start the live-reloading docs server. Needs a virtual environment.
* `mkdocs build` - Build the documentation site.
* `mkdocs -h` - Print help message and exit.

