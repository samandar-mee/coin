package com.sdk.coin.presentation.detail

import com.sdk.coin.domain.model.CoinDetail

sealed class DetailState {
    object Loading: DetailState()
    data class Error(val message: String): DetailState()
    data class Success(val detail: CoinDetail): DetailState()
}