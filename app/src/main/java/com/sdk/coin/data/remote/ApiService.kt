package com.sdk.coin.data.remote

import com.sdk.coin.data.remote.dto.coin_list_dto.CoinListDTO
import com.sdk.coin.utils.Constants
import com.sdk.cryptoapp.data.data_source.dto.coin_detail_dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCoins(@Query("page") page: String): CoinListDTO

    @GET("api/v3/coins/{id}")
    suspend fun getCoinById(
        @Path("id") id: String
    ): CoinDetailDTO
}