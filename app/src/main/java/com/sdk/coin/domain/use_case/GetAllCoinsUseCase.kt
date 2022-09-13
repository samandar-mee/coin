package com.sdk.coin.domain.use_case

import com.sdk.coin.domain.model.Coin
import com.sdk.coin.domain.repository.CoinRepository
import com.sdk.coin.map.toCoin
import com.sdk.coin.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(page: String): Flow<ResponseState<List<Coin>>> {
        return flow {
            try {
                emit(ResponseState.Loading())
                val list = repository.getAllCoins(page).map { it.toCoin() }
                emit(ResponseState.Success(list))
            } catch (e: Exception) {
                emit(ResponseState.Error(e.stackTraceToString()))
            }
        }
    }
}