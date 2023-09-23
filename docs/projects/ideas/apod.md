---
title: 'Astronomy Picture of the Day'
description: 'Project goal: Implement a small app that fetches and displays the Astronomy Picture of the Day using a NASA API.'
hide: [toc]
---

# Project Draft: APOD App

## Project Description

The goal of this project is to implement a small app that fetches and displays the Astronomy Picture of the Day (APOD) using
the [NASA API](https://api.nasa.gov/).

**Skills required**: REST API consumption, loading images, and handling YouTube video links when the APOD features a video.

## Phase 1

In the initial phase:

- Establish a connection to the NASA API using Ktor.
- Fetch the APOD and accompanying data.
- Display the picture or, if the APOD is a video, provide a link to the YouTube video.

The learnings from this phase will be:

- Usage of Ktor for REST API consumption.
- Loading and displaying pictures.
- Handling YouTube video links.

## Phase 2

In the second phase:

- Store the fetched pictures and related information in a local database.

The learnings from this phase will be:

- Utilizing SQLDelight for local data storage and retrieval.
