package com.kugou.navigator

import android.util.Log
import java.net.MalformedURLException
import java.net.URL

object FaviconLoader {
    private const val TAG = "FaviconLoader"

    // 获取网站图标URL
    fun getFaviconUrl(url: String): String {
        return try {
            "https://${URL(url).host}/favicon.ico"
        } catch (e: MalformedURLException) {
            Log.e(TAG, "Invalid URL: $url", e)
            ""
        }
    }
}