package com.sdk.coin.domain.repository

import com.sdk.coin.data.remote.dto.coin_list_dto.CoinListDTO
import com.sdk.cryptoapp.data.data_source.dto.coin_detail_dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getAllCoins(page: String): CoinListDTO
    suspend fun getCoinById(id: String): CoinDetailDTO
}