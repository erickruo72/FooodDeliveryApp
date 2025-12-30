package com.example.foooddeliveryapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foooddeliveryapp.ui.components.CategoryChip
import com.example.foooddeliveryapp.ui.components.RestaurantCard

@Composable
fun HomeScreen(onRestaurantClick: () -> Unit) {
    val categories = listOf("All", "Burgers", "Pizza", "Sushi", "Desserts", "Healthy")
    val dummyRestaurants = listOf(
        Triple("Burger King", "4.5", "20-30"),
        Triple("Pizza Hut", "4.2", "15-25"),
        Triple("Sushi Zen", "4.8", "30-45"),
        Triple("Healthy Greens", "4.9", "10-20")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding() // Ensures content doesn't hit the clock/battery
            .padding(horizontal = 16.dp)
    ) {
        // 1. Fake Search Bar
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            color = Color(0xFFF7F7F7),
            shape = RoundedCornerShape(30.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
                Spacer(Modifier.width(8.dp))
                Text("Search food, restaurants...", color = Color.Gray)
            }
        }

        // 2. Main Scrollable Content
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                LazyRow(modifier = Modifier.padding(bottom = 24.dp)) {
                    items(categories) { cat ->
                        CategoryChip(label = cat, isSelected = cat == "All")
                    }
                }
            }

            item {
                Text(
                    text = "Featured Restaurants",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            // 3. The Feed
            items(dummyRestaurants) { restaurant ->
                RestaurantCard(
                    name = restaurant.first,
                    rating = restaurant.second,
                    time = restaurant.third,
                    priceRange = "$$",
                    onClick = onRestaurantClick
                )
            }
        }
    }
}