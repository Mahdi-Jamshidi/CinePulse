package ir.eitaa.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun HomeScreen(
  viewModel: HomeViewModel,
  onMovieClick: (tmdbId: Int) -> Unit,
) {
  val state by viewModel.state.collectAsStateWithLifecycle()

  if (state.isLoading) {
    CircularProgressIndicator(
        modifier = Modifier.wrapContentSize(),
    )
  } else {
    LazyRow(
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      items(state.items) { item ->
        AsyncImage(
          model = item.posterUrl,
          contentDescription = null,
          modifier = Modifier
              .padding(16.dp)
              .width(200.dp)
              .height(300.dp)
              .clip(RoundedCornerShape(16.dp))
              .clickable {
                item.ids.tmdbId?.let {
                  onMovieClick.invoke(it)
                }
              },
        )
      }
    }
  }
}
