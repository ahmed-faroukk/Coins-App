package com.farouk.compose_mvvm_cleanarch.presentation.coindetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.compose_mvvm_cleanarch.common.Constants
import com.farouk.compose_mvvm_cleanarch.common.Resource
import com.farouk.compose_mvvm_cleanarch.domin.usecase.getcoin.CoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.farouk.compose_mvvm_cleanarch.presentation.coindetails.CoinDetailState
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val coinDetailsUseCase: CoinDetailsUseCase,
    saveStateHandle: SavedStateHandle,
) :  ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state = _state

    init {
        saveStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinDetail(it)
        }
    }


    fun getCoinDetail(id: String) {
        coinDetailsUseCase(id).onEach {
            when (it) {
                is Resource.Success -> {
                    state.value = CoinDetailState(data = it.data)
                }

                is Resource.Error -> {
                    state.value = CoinDetailState(error = it.message ?: "error not found ")
                }

                is Resource.Loading -> {
                    state.value = CoinDetailState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }

}