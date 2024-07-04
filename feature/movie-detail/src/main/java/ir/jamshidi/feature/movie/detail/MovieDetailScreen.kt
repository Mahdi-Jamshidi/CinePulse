package ir.jamshidi.feature.movie.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun MovieDetailScreen(
  viewModel: MovieDetailViewModel,
  onStreamReady: (String) -> Unit
) {
  val state by viewModel.state.collectAsStateWithLifecycle()
  val videoDetail = state.videoDetail
  val navigateToPlayer by viewModel.navigationToPlayer.collectAsStateWithLifecycle(null)

  LaunchedEffect(key1 = navigateToPlayer) {
    navigateToPlayer?.let { streamUrl ->
      onStreamReady(streamUrl)
    }
  }

  if (state.isLoading) {
    CircularProgressIndicator()
  } else if (videoDetail != null) {
    Column(
      modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {

      AsyncImage(
        model = videoDetail.coverUrl,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
      )

      Text(text = videoDetail.title)
      Text(text = videoDetail.description)

      Button(
        onClick = {
            viewModel.loadStreamInfo()
        },
        modifier = Modifier.fillMaxWidth(0.7f)
      ) {
        if (state.isStreamLoading){
          CircularProgressIndicator(
            modifier = Modifier
              .size(16.dp),
            color = Color.White,
            strokeWidth = 2.dp
          )
        } else {
          Text(text = "Watch Now")
        }
      }

      Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(text = "Year: ${videoDetail.year}")
        Text(text = "Original Language: ${videoDetail.originalLanguage}")
        Text(text = videoDetail.spokenLanguages.joinToString(", " ))
      }

      Text(text = videoDetail.genres.joinToString(", " ))
    }
  }
}
