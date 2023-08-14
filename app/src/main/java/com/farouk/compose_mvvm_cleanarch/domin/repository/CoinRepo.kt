package com.farouk.compose_mvvm_cleanarch.domin.repository

import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDetailDto
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDto

interface CoinRepo {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}