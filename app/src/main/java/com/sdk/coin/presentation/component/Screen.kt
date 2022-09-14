package com.sdk.coin.presentation.component

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("list_screen")
    object DetailScreen: Screen("detail_screen")
}