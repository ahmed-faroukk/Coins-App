package com.farouk.compose_mvvm_cleanarch.data.remote

import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDetailDto
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto

}