package com.baroni.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baroni.myapplication.repositories.Category
import com.baroni.myapplication.repositories.RestaurantsRepository


@Composable
fun ExploreScreen(
    contentPadding: PaddingValues,
    onTitleChanged: (String) -> Unit,
    onNavigateToRestaurant: (String) -> Unit,
) {
    onTitleChanged("Explore")

    RestaurantList(
        categories = RestaurantsRepository().getRestaurants(),
        contentPadding = contentPadding,
        onNavigateToRestaurant = onNavigateToRestaurant
    )
}

@Composable
fun RestaurantList(
    categories: List<Category>,
    contentPadding: PaddingValues,
    onNavigateToRestaurant: (String) -> Unit,
) {
    LazyVerticalGrid (
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        state = rememberLazyGridState()
    ) {
        items(categories) { restaurant ->
            RestaurantCard(category = restaurant, onNavigateToRestaurant = onNavigateToRestaurant)
        }
    }
}

@Composable
fun RestaurantCard(category: Category, onNavigateToRestaurant: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onNavigateToRestaurant(category.name)
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Column(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(category.imageId),
                contentDescription = "restaurant",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    category.name,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(
                        start = 16.dp, end = 16.dp
                    )
                )
            }
        }
    }
}
