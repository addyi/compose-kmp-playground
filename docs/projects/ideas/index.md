---
title: Project Ideas
description: Project Ideas for the future
hide: [toc]
---

# Project Ideas

1. [**APOD App**](apod.md): A small application that fetches and displays the Astronomy Picture of the Day (APOD) using the NASA API. The
   focus is on using Ktor for REST API consumption, loading images, and handling YouTube video links in case the APOD is a video.

2. [**Habit Tracking App**](habit.md): An application for tracking habits (like brushing teeth after meals). The app will involve handling
   stored user data, managing dates, and possibly sending user notifications.

3. [**Limerick Generator with ChatGPT**](limerick.md): An application that interacts with OpenAI's ChatGPT to generate limericks about
   specific topics. The main learning area is the interaction with the ChatGPT API.

4. [**Pokédex App**](pokedex.md): An app that fetches and displays Pokémon data using the PokéAPI. Similar to the APOD app, this project
   involves using Ktor for REST API consumption and handling images.

5. [**GPS Speedometer App**](speed.md): An application that uses GPS to display the current speed, distance traveled since the start of the
   measurement, and maximum speed. This project will involve using native Android and iOS APIs to access GPS data and to handle location
   permissions.

## Additional Ideas and Plans

- Check out Coil after its KMP support is [ready](https://github.com/coil-kt/coil/issues/842#issuecomment-1622516075). They've gotten a
  grand to implement coil for KMP: https://kotlinfoundation.org/news/grants-program-winners-23/. So far it seems they are the best contender
  for a KMP image loading library so far.
- Mental Arithmetic Trainer similar to [Math Workout Pro](https://play.google.com/store/apps/details?id=io.pro.mathworkout)
- Add KMP desktop
    - see <https://youtu.be/HpfFu2nl32s?t=1850>
    - > If you want to create an application targeting desktop platforms – Windows, macOS, or Linux – use
      the [Compose Multiplatform desktop application template][composeDesktop].
- Count down timer that helps to thoroughly chew food

[composeDesktop]: https://github.com/JetBrains/compose-multiplatform-desktop-template#readme
