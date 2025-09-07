package com.kugou.navigator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun FaviconImage(url: String) {
    val painter = rememberAsyncImagePainter(
        model = url,
        placeholder = painterResource(R.drawable.ic_default_favicon),
        error = painterResource(R.drawable.ic_default_favicon)
    )

    when (painter.state) {
        is AsyncImagePainter.State.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                strokeWidth = 2.dp
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