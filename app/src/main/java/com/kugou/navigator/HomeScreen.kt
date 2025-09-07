package com.kugou.navigator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onWebsiteClick: (AIWebsite) -> Unit,
    viewModel: HomeViewModel
) {
    // 获取状态
    val categories by viewModel.categories.collectAsState(initial = emptyList())
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    // 过滤后的网站列表
    val filteredWebsites by remember(categories, selectedCategory, searchQuery) {
        derivedStateOf {
            val allWebsites = categories.flatMap { it.websites }

            // 按分类过滤
            val categoryFiltered = if (selectedCategory != null) {
                allWebsites.filter { it.category == selectedCategory }
            } else {
                allWebsites
            }

            // 按搜索词过滤
            if (searchQuery.isBlank()) {
                categoryFiltered
            } else {
                categoryFiltered.filter { website ->
                    website.name.contains(searchQuery, ignoreCase = true) ||
                            website.description.contains(searchQuery, ignoreCase = true) ||
                            website.category.contains(searchQuery, ignoreCase = true)
                }
            }
        }
    }

    // 分组网站（按分类）
    val groupedWebsites by remember(filteredWebsites) {
        derivedStateOf {
            if (selectedCategory != null) {
                mapOf(selectedCategory!! to filteredWebsites)
            } else {
                filteredWebsites.groupBy { it.category }
            }
        }
    }

    // 滚动状态
    val lazyListState = rememberLazyListState()

    // 当搜索词变化时滚动到顶部
    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotBlank()) {
            lazyListState.scrollToItem(0)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "AI导航",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 搜索栏
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChanged = viewModel::updateSearchQuery,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // 分类筛选器
            CategoryFilter(
                categories = categories.map { it.name },
                selectedCategory = selectedCategory,
                onCategorySelected = viewModel::selectCategory,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // 内容区域
            if (filteredWebsites.isEmpty()) {
                // 空状态
                EmptyState(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
            } else {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    // 显示搜索结果标题
                    if (searchQuery.isNotBlank()) {
                        item {
                            Text(
                                text = "搜索结果 (${filteredWebsites.size})",
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(16.dp, 8.dp)
                            )
                        }
                    }

                    // 按分类分组显示
                    groupedWebsites.forEach { (category, websites) ->
                        // 分类标题（在非搜索模式下显示）
                        if (searchQuery.isBlank()) {
                            stickyHeader {
                                CategoryHeader(
                                    category = category,
                                    websiteCount = websites.size,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.background)
                                        .padding(horizontal = 16.dp, vertical = 8.dp)
                                )
                            }
                        }

                        // 网站列表
                        items(websites) { website ->
                            WebsiteCard(
                                website = website,
                                isFavorite = favorites.contains(website.id),
                                onItemClick = { onWebsiteClick(website) },
                                onFavoriteClick = { viewModel.toggleFavorite(website.id) },
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "搜索",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "搜索AI网站...",
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary
                ),
                singleLine = true,
                trailingIcon = {
                    if (searchQuery.isNotBlank()) {
                        IconButton(
                            onClick = { onSearchQueryChanged("") }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "清除搜索",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun CategoryFilter(
    categories: List<String>,
    selectedCategory: String?,
    onCategorySelected: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        // "全部"选项
        item {
            FilterChip(
                selected = selectedCategory == null,
                onClick = { onCategorySelected(null) },
                label = { Text("全部") },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }

        // 分类选项
        items(categories) { category ->
            FilterChip(
                selected = selectedCategory == category,
                onClick = { onCategorySelected(category) },
                label = { Text(category) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}

@Composable
fun CategoryHeader(
    category: String,
    websiteCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "($websiteCount)",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Composable
fun WebsiteCard(
    website: AIWebsite,
    isFavorite: Boolean,
    onItemClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 网站图标
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                FaviconImage(
                    url = website.faviconUrl
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // 网站信息
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = website.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = website.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = website.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 收藏按钮
            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavorite) "取消收藏" else "收藏",
                    tint = if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
fun EmptyState(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "无结果",
                modifier = Modifier.size(64.dp),
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "未找到匹配的AI网站",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "尝试不同的搜索词或选择其他分类",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )
        }
    }
}