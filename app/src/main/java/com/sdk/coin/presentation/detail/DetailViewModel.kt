package com.sdk.coin.presentation.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.coin.domain.model.CoinDetail
import com.sdk.coin.domain.use_case.GetCoinByIdUseCase
import com.sdk.coin.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: GetCoinByIdUseCase
) : ViewModel() {

    private var _state: MutableState<DetailState> = mutableStateOf(DetailState.Loading)
    var state: State<DetailState> = _state

    fun getCoinByName(name: String) {
        viewModelScope.launch {
            useCase(name)
                .collectLatest {
                    when (it) {
                        is ResponseState.Loading -> _state.value = DetailState.Loading
                        is ResponseState.Error -> _state.value = DetailState.Error(it.message!!)
                        is ResponseState.Success -> _state.value = DetailState.Success(it.data!!)
                    }
                }
        }
    }
}