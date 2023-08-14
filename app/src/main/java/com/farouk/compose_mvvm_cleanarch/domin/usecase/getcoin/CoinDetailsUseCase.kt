package com.farouk.compose_mvvm_cleanarch.domin.usecase.getcoin

import com.farouk.compose_mvvm_cleanarch.common.Resource
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.toCoin
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.toCoinDetail
import com.farouk.compose_mvvm_cleanarch.domin.model.Coin
import com.farouk.compose_mvvm_cleanarch.domin.model.CoinDetail
import com.farouk.compose_mvvm_cleanarch.domin.repository.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailsUseCase  @Inject constructor(
    private val repo: CoinRepo,
) {

    operator fun invoke(id : String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val response = repo.getCoinById(id).toCoinDetail()
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred", null))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection.", null))
        }
    }
}