package com.sdk.coin.data.repository

import com.sdk.coin.data.remote.ApiService
import com.sdk.coin.data.remote.dto.coin_detail_dto.CoinDetailDTO
import com.sdk.coin.data.remote.dto.coin_list_dto.CoinListDTO
import com.sdk.coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CoinRepository {
    override suspend fun getAllCoins(page: String): CoinListDTO {
        return apiService.getAllCoins(page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return apiService.getCoinById(id)
    }
}