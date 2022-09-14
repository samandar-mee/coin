package com.sdk.coin.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.coin.domain.use_case.GetAllCoinsUseCase
import com.sdk.coin.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val useCase: GetAllCoinsUseCase
) : ViewModel() {
    private var _state: MutableState<CoinListState> = mutableStateOf(CoinListState.Loading)
    var state: State<CoinListState> = _state

    init {
        getAllCoinList("1")
    }

    fun getAllCoinList(page: String) {
        viewModelScope.launch {
            useCase(page)
                .collectLatest {
                    when (it) {
                        is ResponseState.Loading -> _state.value = CoinListState.Loading
                        is ResponseState.Error -> _state.value = CoinListState.Error(it.message!!)
                        is ResponseState.Success -> _state.value = CoinListState.Success(it.data!!)
                    }
                }
        }
    }
}