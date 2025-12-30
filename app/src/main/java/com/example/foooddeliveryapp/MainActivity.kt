package com.example.foooddeliveryapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.foooddeliveryapp.ui.navigation.AppNavigation
import com.example.foooddeliveryapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Makes the content flow under the status bar (modern UI)
        enableEdgeToEdge()

        setContent {
            FoodAppTheme {
                AppNavigation()
            }
        }
    }
}