package com.sdk.coin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sdk.coin.presentation.component.Screen
import com.sdk.coin.presentation.detail.DetailScreen
import com.sdk.coin.presentation.list.CoinListScreen
import com.sdk.coin.ui.theme.CoinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = "${Screen.DetailScreen.route}/{name}",
                            arguments = listOf(
                                navArgument(name = "name") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val name = it.arguments?.getString("name") ?: ""
                            DetailScreen(navController = navController, name)
                        }
                    }
                }
            }
        }
    }
}

