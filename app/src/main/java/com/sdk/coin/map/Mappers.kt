package com.sdk.coin.map

import com.sdk.coin.data.remote.dto.coin_list_dto.CoinListDTOItem
import com.sdk.coin.domain.model.Coin
import com.sdk.coin.domain.model.CoinDetail
import com.sdk.cryptoapp.data.data_source.dto.coin_detail_dto.CoinDetailDTO

fun CoinListDTOItem.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        image = image,
        marketCap = market_cap,
        price = current_price,
        pricePerChange = price_change_percentage_24h,
        lowPrice = low_24h,
        highPrice = high_24h
    )
}

fun CoinDetailDTO.toCoinDetail(): CoinDetail {
    return CoinDetail(
        image = image.large,
        name = name
    )
}