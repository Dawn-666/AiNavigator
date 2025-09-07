package com.kugou.navigator

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun FaviconImage(url: String) {
    val context = LocalContext.current
    val imageLoader = remember { ImageLoader(context) }

    // 使用 rememberAsyncImagePainter 的正确方式
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(url)
            .size(Size.ORIGINAL) // 使用原始尺寸
            .crossfade(true)
            .build(),
        imageLoader = imageLoader
    )

    // 使用 LaunchedEffect 监控状态变化
    LaunchedEffect(url) {
        snapshotFlow { painter.state }
            .collect { state ->
                when (state) {
                    is AsyncImagePainter.State.Loading -> {
                        Log.d("FaviconImage", "Loading favicon: $url")
                    }

                    is AsyncImagePainter.State.Success -> {
                        Log.d("FaviconImage", "Loaded favicon: $url")
                    }

                    is AsyncImagePainter.State.Error -> {
                        Log.e("FaviconImage", "Error loading favicon: $url", state.result.throwable)
                    }

                    else -> {}
                }
            }
    }

    Box(
        modifier = Modifier.size(32.dp),
        contentAlignment = Alignment.Center
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }

            is AsyncImagePainter.State.Error -> {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_favicon),
                    contentDescription = "默认图标",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }

            else -> {
                Image(
                    painter = painter,
                    contentDescription = "网站图标",
                    modifier = Modifier.size(32.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}