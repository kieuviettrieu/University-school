package com.example.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MyCityAppTheme
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.data.MyCityUiState
import com.example.mycityapp.model.Recommendation

/* TODO */
@Composable
fun RecommendationListAndDetail(
    myCityUiState: MyCityUiState,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
}


@Composable
fun RecommendationListScreen(
    recommendationList: List<Recommendation>,
    onCardClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(recommendationList) {recommendation ->
            RecommendationCard(
                recommendation = recommendation,
                selected = false,
                onCardClick = { onCardClick(recommendation) },
                modifier = Modifier.padding(8.dp),
                key = recommendation.id
            )
        }
    }

}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    selected: Boolean,
    onCardClick: (Recommendation) -> Unit,
    key: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { onCardClick(recommendation) },
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.tertiaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(recommendation.titleResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RecommendationCardPreview() {
    MyCityAppTheme {
        RecommendationCard(
            recommendation = DataSource.defaultRecommendation,
            selected = false,
            onCardClick = {},
            key = DataSource.defaultRecommendation.id
        )
    }
}