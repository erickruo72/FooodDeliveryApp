package com.example.foooddeliveryapp.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryRed,
    onPrimary = OnPrimaryWhite,
    secondaryContainer = SecondaryContainerRed,
    onSecondaryContainer = PrimaryRed,
    background = SurfaceWhite,
    surface = SurfaceWhite,
    onSurface = DarkGrey,
    onSurfaceVariant = MediumGrey
)

@Composable
fun FoodAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}