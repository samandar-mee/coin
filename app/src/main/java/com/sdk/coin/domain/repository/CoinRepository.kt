package com.sdk.coin.domain.repository

import com.sdk.coin.data.remote.dto.coin_detail_dto.CoinDetailDTO
import com.sdk.coin.data.remote.dto.coin_list_dto.CoinListDTO

interface CoinRepository {
    suspend fun getAllCoins(page: String): CoinListDTO
    suspend fun getCoinById(id: String): CoinDetailDTO
}