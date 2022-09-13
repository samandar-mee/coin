package com.sdk.coin.utils

sealed class ResponseState <T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null): ResponseState<T>(data)
    class Error<T>(message: String? = null, data: T? = null): ResponseState<T>(data, message)
    class Success<T>(data: T?): ResponseState<T>(data)
}