package ir.jamshidi.cinepulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.jamshidi.cinepulse.ui.theme.CinePulseTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CinePulseTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background,
        ) {
          Greeting("Android")
        }
      }
    }
  }
}

const val APIKey = "0bd8ab8a071e48254bbb2d425cfb249b"
const val APIReadAccessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYmQ4YWI4YTA3MWU0ODI1NGJiYjJkNDI1Y2ZiMjQ5YiIsInN1YiI6IjY2NTlmZjc3ZjZmZmU5NjFiNjcxNjE5NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5J9AsVr4lINP2Dw8rWiVfa1eGtVfTS_34XIrjYCC-ZM"
@Composable
fun Greeting(
  name: String,
  modifier: Modifier = Modifier,
) {
  Text(
    text = "Hello $name!",
    modifier = modifier,
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  CinePulseTheme {
    Greeting("Android")
  }
}
