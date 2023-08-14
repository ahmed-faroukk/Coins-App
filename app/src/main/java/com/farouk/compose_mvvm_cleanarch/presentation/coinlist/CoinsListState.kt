package com.farouk.compose_mvvm_cleanarch.presentation.coinlist

import com.farouk.compose_mvvm_cleanarch.domin.model.Coin

data class CoinsListState(
    val data : List<Coin> = emptyList() ,
    val isLoading : Boolean = false ,
    val error : String = ""
)
