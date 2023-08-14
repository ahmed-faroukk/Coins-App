package com.farouk.compose_mvvm_cleanarch.domin.usecase.getcoins

import com.farouk.compose_mvvm_cleanarch.common.Resource
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.toCoin
import com.farouk.compose_mvvm_cleanarch.domin.model.Coin
import com.farouk.compose_mvvm_cleanarch.domin.repository.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepo,
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repo.getCoins().map { it.toCoin() }
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred", null))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection.", null))
        }
    }
}