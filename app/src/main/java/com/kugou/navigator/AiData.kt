package com.kugou.navigator

// 移除AICategory中的iconRes
data class AICategory(
    val id: Int,
    val name: String,
    val websites: List<AIWebsite>
)

// 添加faviconUrl到AIWebsite
data class AIWebsite(
    val id: Int,
    val name: String,
    val url: String,
    val description: String,
    val category: String,
    val faviconUrl: String = FaviconLoader.getFaviconUrl(url), // 网站图标URL
    val isFavorite: Boolean = false
)