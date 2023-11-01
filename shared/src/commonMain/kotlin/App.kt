import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.addyi.playground.apod.di.apodModule
import io.github.addyi.playground.apod.domain.apod.ApodClient
import io.github.addyi.playground.core.di.coreModule
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    KoinApplication(
        application = {
            modules(listOf(coreModule, apodModule))
        }
    ) {
        MaterialTheme {
            val apodClient = koinInject<ApodClient>()
            var apodText by remember { mutableStateOf("") }

            var greetingText by remember { mutableStateOf("Hello, World!") }
            var showImage by remember { mutableStateOf(false) }

            LaunchedEffect(true) {
                apodText = apodClient.getApod(null).toString()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        greetingText = "Hello, ${getPlatformName()}"
                        showImage = !showImage
                    },
                    content = { Text(greetingText) }
                )

                Text(
                    text = apodText,
                    modifier = Modifier
                )

                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
            }
        }
    }
}

expect fun getPlatformName(): String
