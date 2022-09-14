package com.sdk.coin.presentation.list

import com.sdk.coin.domain.model.Coin

sealed class CoinListState {
    object Loading: CoinListState()
    data class Error(val message: String): CoinListState()
    data class Success(val coins: List<Coin>): CoinListState()
}