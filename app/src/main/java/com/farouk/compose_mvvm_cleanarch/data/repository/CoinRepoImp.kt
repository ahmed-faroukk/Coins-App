package com.farouk.compose_mvvm_cleanarch.data.repository

import com.farouk.compose_mvvm_cleanarch.data.remote.CoinApi
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDetailDto
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDto
import com.farouk.compose_mvvm_cleanarch.domin.repository.CoinRepo
import javax.inject.Inject

class CoinRepoImp @Inject constructor(
   private val api : CoinApi
) : CoinRepo {
    override suspend fun getCoins(): List<CoinDto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}