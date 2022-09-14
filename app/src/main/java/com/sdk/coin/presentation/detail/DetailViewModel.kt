package com.sdk.coin.presentation.detail

import androidx.lifecycle.ViewModel
import com.sdk.coin.domain.use_case.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: GetCoinByIdUseCase
): ViewModel() {


}