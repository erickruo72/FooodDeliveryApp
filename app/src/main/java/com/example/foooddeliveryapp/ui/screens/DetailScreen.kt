package com.example.foooddeliveryapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(onBack: () -> Unit) {
    val menuItems = listOf("Classic Cheeseburger", "Spicy Chicken Sandwich", "Large Fries", "Vanilla Shake")

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            // Hero Image Placeholder
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(Color(0xFFE0E0E0))
                )
            }

            // Restaurant Info
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Burger King",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "American • Burgers • Fast Food",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Full Menu",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Fake Menu Items
            items(menuItems.size) { index ->
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(menuItems[index], style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text("$12.99", style = MaterialTheme.typography.bodyMedium)
                    }
                    IconButton(
                        onClick = { /* Add to cart */ },
                        colors = IconButtonDefaults.filledIconButtonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                }
            }
        }

        // Floating Back Button
        FilledIconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(top = 48.dp, start = 16.dp) // Adjusted for status bar
                .size(40.dp),
            colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.White)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.Black)
        }
    }
}