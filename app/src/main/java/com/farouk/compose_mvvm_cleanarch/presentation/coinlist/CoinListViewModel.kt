package com.farouk.compose_mvvm_cleanarch.presentation.coinlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.compose_mvvm_cleanarch.common.Resource
import com.farouk.compose_mvvm_cleanarch.domin.usecase.getcoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.farouk.compose_mvvm_cleanarch.presentation.coinlist.CoinsListState
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
   private val getCoinsUseCase: GetCoinsUseCase

) : ViewModel() {
    private val _state = mutableStateOf(CoinsListState())
    val state =  _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach {
            when(it){
                is Resource.Success->{
                    state.value = CoinsListState(data = it.data ?: emptyList())
                }
                is Resource.Loading->{
                    state.value = CoinsListState(isLoading = true)
                }
                is Resource.Error->{
                    state.value = CoinsListState(error = it.message ?: "error not found")
                }
            }
        }.launchIn(viewModelScope)
    }
}