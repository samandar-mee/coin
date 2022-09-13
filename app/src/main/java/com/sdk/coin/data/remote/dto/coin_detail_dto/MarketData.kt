package com.sdk.cryptoapp.data.data_source.dto.coin_detail_dto

import com.sdk.coin.data.remote.dto.coin_detail_dto.Ath

data class MarketData(
    val ath: Ath,
    val ath_change_percentage: AthChangePercentage,
    val ath_date: AthDate,
    val atl: Atl,
    val atl_change_percentage: AtlChangePercentage,
    val atl_date: AtlDate,
    val circulating_supply: Double,
    val current_price: CurrentPrice,
    val fdv_to_tvl_ratio: Any,
    val fully_diluted_valuation: FullyDilutedValuation,
    val high_24h: High24h,
    val last_updated: String,
    val low_24h: Low24h,
    val market_cap: MarketCap,
    val market_cap_change_24h: Long,
    val market_cap_change_24h_in_currency: MarketCapChange24hInCurrency,
    val market_cap_change_percentage_24h: Double,
    val market_cap_change_percentage_24h_in_currency: MarketCapChangePercentage24hInCurrency,
    val market_cap_rank: Int,
    val max_supply: Double,
    val mcap_to_tvl_ratio: Any,
    val price_change_24h: Double,
    val price_change_24h_in_currency: PriceChange24hInCurrency,
    val price_change_percentage_14d: Double,
    val price_change_percentage_14d_in_currency: PriceChangePercentage14dInCurrency,
    val price_change_percentage_1h_in_currency: PriceChangePercentage1hInCurrency,
    val price_change_percentage_1y: Double,
    val price_change_percentage_1y_in_currency: PriceChangePercentage1yInCurrency,
    val price_change_percentage_200d: Double,
    val price_change_percentage_200d_in_currency: PriceChangePercentage200dInCurrency,
    val price_change_percentage_24h: Double,
    val price_change_percentage_24h_in_currency: PriceChangePercentage24hInCurrency,
    val price_change_percentage_30d: Double,
    val price_change_percentage_30d_in_currency: PriceChangePercentage30dInCurrency,
    val price_change_percentage_60d: Double,
    val price_change_percentage_60d_in_currency: PriceChangePercentage60dInCurrency,
    val price_change_percentage_7d: Double,
    val price_change_percentage_7d_in_currency: PriceChangePercentage7dInCurrency,
    val roi: Any,
    val total_supply: Double,
    val total_value_locked: Any,
    val total_volume: TotalVolume
)