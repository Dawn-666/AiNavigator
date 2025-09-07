package com.kugou.navigator
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    // 分类数据
    private val _categories = MutableStateFlow<List<AICategory>>(emptyList())
    val categories = _categories.asStateFlow()

    // 选中的分类
    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()

    // 搜索词
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    // 收藏列表
    private val _favorites = MutableStateFlow<Set<Int>>(emptySet())
    val favorites = _favorites.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _categories.value = DataProvider.getAICategories()
        }
    }

    fun selectCategory(category: String?) {
        _selectedCategory.value = category
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleFavorite(websiteId: Int) {
        _favorites.update { currentFavorites ->
            if (currentFavorites.contains(websiteId)) {
                currentFavorites - websiteId
            } else {
                currentFavorites + websiteId
            }
        }
    }
}