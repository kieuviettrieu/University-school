package com.example.mycityapp.data

import androidx.annotation.StringRes
import com.example.mycityapp.R
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.Recommendation

data class MyCityUiState (
    /** Selected Category*/
    val currentCategory: Category = DataSource.defaultCategory,
    val currentRecommendation: Recommendation = DataSource.defaultRecommendation,
    val categoryList: List<Category> = emptyList(),
    val recommendationList: List<Recommendation> = emptyList(),
    @StringRes val headerTitleId: Int = R.string.app_name,
    val isShowingListPage: Boolean = true
)