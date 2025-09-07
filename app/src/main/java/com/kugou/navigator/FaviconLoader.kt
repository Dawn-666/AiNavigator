package com.kugou.navigator

import android.util.Log
import java.net.URL

object FaviconLoader {
    private const val TAG = "FaviconLoader"

    // 获取网站图标URL
    fun getFaviconUrl(url: String): String {
        val domain = try {
            URL(url).host
        } catch (e: Exception) {
            Log.e(TAG, "Invalid URL: $url", e)
            return ""
        }
        return "https://$domain/favicon.ico"
    }
}