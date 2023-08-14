package com.farouk.compose_mvvm_cleanarch.presentation.components

sealed class ScreenRoutes(val route : String){
    object CoinsListScreen : ScreenRoutes("coin_list_screen")
    object CoinsDetailScreen : ScreenRoutes("coin_detail_screen")

}
