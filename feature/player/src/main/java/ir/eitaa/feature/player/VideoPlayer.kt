package ir.eitaa.feature.player

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(uri: Uri) {
  val context = LocalContext.current
  var lastVideoPosition by rememberSaveable { mutableStateOf(0L) }

  val exoPlayer = remember {
    ExoPlayer.Builder(context)
      .build().apply {
        val mediaItem = MediaItem.Builder()
          .setUri(uri)
          .build()
        setMediaItem(mediaItem)
        playWhenReady = true
        prepare()
      }
  }

  val lifecycleOwner = rememberUpdatedState(newValue = LocalLifecycleOwner.current)

  DisposableEffect(key1 = lifecycleOwner) {

    val observer = LifecycleEventObserver { owner: LifecycleOwner, event: Lifecycle.Event ->
      when (event) {
        Event.ON_RESUME -> {
          exoPlayer.play()
          exoPlayer.seekTo(lastVideoPosition)
        }
        Event.ON_PAUSE -> {
          exoPlayer.pause()
        }
        else -> Unit
      }
    }

    val lifecycle = lifecycleOwner.value.lifecycle
    lifecycle.addObserver(observer)

    onDispose {
      lastVideoPosition = exoPlayer.contentPosition
      exoPlayer.release()
      lifecycle.removeObserver(observer)
    }
  }

  AndroidView(
    factory = { context ->
      PlayerView(context).apply {
        player = exoPlayer
      }
    },
  )
}
