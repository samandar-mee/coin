package com.sdk.coin.domain.model


data class Coin(
    val id: String,
    val name: String,
    val image: String,
    val marketCap: Long,
    val price: Double,
    val pricePerChange: Double,
    val lowPrice: Double,
    val highPrice: Double
)