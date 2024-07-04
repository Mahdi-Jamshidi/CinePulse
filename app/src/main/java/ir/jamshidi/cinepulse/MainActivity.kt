package ir.jamshidi.cinepulse

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import ir.eitaa.feature.home.HomeScreen
import ir.eitaa.feature.player.VideoPlayer
import ir.jamshidi.cinepulse.ui.theme.CinePulseTheme
import ir.jamshidi.feature.movie.detail.MovieDetailScreen
import ir.jamshidi.feature.movie.detail.MovieDetailViewModel

@AndroidEntryPoint
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
//          MovieDetailScreen(viewModel = hiltViewModel())


          val navController = rememberNavController()
          NavHost(navController = navController, startDestination = "home") {

            composable(route = "home") {
              HomeScreen(viewModel = hiltViewModel()){ tmdbId ->
                navController.navigate("detail/$tmdbId")
              }
            }

            composable(
              route = "detail/{movie_id}",
              arguments = listOf(navArgument("movie_id") { type = NavType.IntType })
            ) {
              MovieDetailScreen(
                viewModel = hiltViewModel(),
                  onStreamReady = { streamUrl ->
                    val encoded = Uri.encode(streamUrl)
                    navController.navigate("player/$encoded")
                  }
                )
            }

            composable(
              route = "player/{stream_url}",
              arguments = listOf(
                navArgument("stream_url") {
                  type = NavType.StringType
                }
              )
            ) { backStackEntry ->
              val streamUrl = backStackEntry.arguments?.getString("stream_url")
              val decoded = Uri.decode(streamUrl)
              VideoPlayer(uri = Uri.parse(decoded))
            }
          }
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
