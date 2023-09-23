---
title: First changes
description: Adding a text field to the Compose Multiplatform app
icon: fontawesome/solid/person-running
hide: [toc]
---

# First changes

!!! info
    This documentation is a copy of the [Jetpack Compose Multiplatform documentation][officialDoc].

[officialDoc]: https://github.com/JetBrains/compose-multiplatform-ios-android-template/#readme


## Make your first changes

You can now make some changes in the code and check that they are visible in both the iOS and Android applications at the same time:

In Android Studio, navigate to the `shared/src/commonMain/kotlin/App.kt` file. This is the common entry point for your Compose Multiplatform app.

Here, you see the code responsible for rendering the "Hello, World!" button and the animated Compose Multiplatform logo:

```kotlin
@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
   MaterialTheme {
       var greetingText by remember { mutableStateOf("Hello, World!") }
       var showImage by remember { mutableStateOf(false) }
       Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
           Button(onClick = {
               greetingText = "Hello, ${getPlatformName()}"
               showImage = !showImage
           }) {
               Text(greetingText)
           }
           AnimatedVisibility(showImage) {
               Image(
                   painterResource("compose-multiplatform.xml"),
                   null
               )
           }
       }
   }
}
```

Update the shared code by adding a text field that will update the name displayed on the button:

```diff
@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
   MaterialTheme {
       var greetingText by remember { mutableStateOf("Hello, World!") }
       var showImage by remember { mutableStateOf(false) }
       Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
           Button(onClick = {
               greetingText = "Hello, ${getPlatformName()}"
               showImage = !showImage
           }) {
               Text(greetingText)
           }
+           TextField(greetingText, onValueChange = { greetingText = it })
           AnimatedVisibility(showImage) {
               Image(
                   painterResource("compose-multiplatform.xml"),
                   null
               )
           }
       }
   }
}
```

Re-run both the `androidApp` and `iosApp` configurations. You'll see this change reflected in both the Android and iOS apps.

## Next steps

We encourage you to explore Compose Multiplatform further and try out more projects:

* [Learn about other cases for using the Compose Multiplatform UI framework](https://github.com/JetBrains/compose-multiplatform#readme)
* [Create an application targeting Windows, macOS, and Linux with Compose Multiplatform for Desktop](https://github.com/JetBrains/compose-multiplatform-desktop-template#readme)
* [Complete more Compose Multiplatform tutorials](https://github.com/JetBrains/compose-multiplatform/blob/master/tutorials/README.md)
* [Explore some more advanced Compose Multiplatform example projects](https://github.com/JetBrains/compose-multiplatform/blob/master/examples/README.md)
