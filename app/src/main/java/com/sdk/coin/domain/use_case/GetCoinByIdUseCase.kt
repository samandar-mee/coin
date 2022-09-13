package com.sdk.coin.domain.use_case

import com.sdk.coin.domain.model.CoinDetail
import com.sdk.coin.domain.repository.CoinRepository
import com.sdk.coin.map.toCoinDetail
import com.sdk.coin.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(id: String): Flow<ResponseState<CoinDetail>> {
        return flow {
            try {
                emit(ResponseState.Loading())
                val detail = repository.getCoinById(id).toCoinDetail()
                emit(ResponseState.Success(detail))
            } catch (e: Exception) {
                emit(ResponseState.Error(e.stackTraceToString()))
            }
        }
    }
}