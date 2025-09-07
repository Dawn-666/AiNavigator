package com.kugou.navigator

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import coil.Coil
import coil.request.ImageRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

object FaviconLoader {
    private const val TAG = "FaviconLoader"

    // 内存缓存
    private val faviconCache = mutableMapOf<String, Bitmap>()

    // 获取网站图标URL
    fun getFaviconUrl(url: String): String {
        val domain = try {
            URL(url).host
        } catch (e: Exception) {
            Log.e(TAG, "Invalid URL: $url", e)
            return ""
        }
        return "https://$domain/favicon.ico"//"https://www.google.com/s2/favicons?domain=$domain&sz=64"
    }

    // 异步加载图标
    fun loadFavicon(
        context: Context,
        url: String,
        onSuccess: (Bitmap) -> Unit,
        onError: (Exception) -> Unit = {}
    ) {
        val faviconUrl = getFaviconUrl(url)

        // 检查缓存
        faviconCache[faviconUrl]?.let {
            onSuccess(it)
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = ImageRequest.Builder(context)
                    .data(faviconUrl)
                    .build()

                val result = Coil.imageLoader(context).execute(request)
                val bitmap = result.drawable?.toBitmap()

                bitmap?.let {
                    // 添加到缓存
                    faviconCache[faviconUrl] = it
                    onSuccess(it)
                } ?: run {
                    throw Exception("Failed to load favicon")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading favicon for $url", e)
                onError(e)
            }
        }
    }

    // Compose函数：获取网站图标
    @Composable
    fun rememberFaviconPainter(url: String): ImageBitmap? {
        val context = LocalContext.current
        val faviconUrl = remember(url) { getFaviconUrl(url) }

        return remember(faviconUrl) {
            // 检查缓存
            faviconCache[faviconUrl]?.asImageBitmap() ?: run {
                // 异步加载
                loadFavicon(context, url, {}, {})
                null
            }
        }
    }
}