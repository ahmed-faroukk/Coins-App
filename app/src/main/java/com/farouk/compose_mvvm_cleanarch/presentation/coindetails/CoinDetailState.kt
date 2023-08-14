package com.farouk.compose_mvvm_cleanarch.presentation.coindetails

import com.farouk.compose_mvvm_cleanarch.domin.model.CoinDetail

data class CoinDetailState(
    val data : CoinDetail ?= null ,
    val isLoading : Boolean = false , 
    val error : String = ""
)
