package com.example.mycityapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.R

enum class MyCityScreen {
    CATEGORY,
    RECOMMENDATION,
    DETAIL
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    @StringRes headerResId: Int,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = headerResId),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.CATEGORY.name
    )

    val uiState by viewModel.uiState.collectAsState()

//    /** show content based on the window size **/
//    val contentType = when (windowSize) {
//        WindowWidthSizeClass.Compact,
//        WindowWidthSizeClass.Medium -> MyCityAppContentType.LIST_ONLY
//        WindowWidthSizeClass.Expanded -> MyCityAppContentType.LIST_AND_DETAIL
//        else -> MyCityAppContentType.LIST_ONLY
//    }
    Scaffold(
        topBar = {
            MyCityAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                currentScreen = currentScreen,
                headerResId = if (currentScreen == MyCityScreen.CATEGORY)
                    R.string.app_name
                else
                    uiState.headerTitleId
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityScreen.CATEGORY.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyCityScreen.CATEGORY.name) {
                CategoryListScreen(
                    categoryList = uiState.categoryList,
                    onCardClick = {
                        viewModel.setCategory(it)
                        navController.navigate(MyCityScreen.RECOMMENDATION.name)
                    }
                )
            }
            composable(route = MyCityScreen.RECOMMENDATION.name) {
                RecommendationListScreen(
                    recommendationList = uiState.recommendationList,
                    onCardClick = {
                        viewModel.setRecommendation(it)
                        navController.navigate(MyCityScreen.DETAIL.name)
                    }
                )
            }
            composable(route = MyCityScreen.DETAIL.name) {
                DetailsScreen(
                    recommendation = uiState.currentRecommendation
                )
            }
        }

    }


}