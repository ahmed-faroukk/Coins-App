package com.farouk.compose_mvvm_cleanarch.presentation.coinlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.farouk.compose_mvvm_cleanarch.R
import com.farouk.compose_mvvm_cleanarch.presentation.components.ScreenRoutes
import com.farouk.compose_mvvm_cleanarch.presentation.coinlist.components.CoinListItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value


    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        item {
            val lazyListState = rememberLazyListState()
            var scrolledY = 0f
            var previousOffset = 0
            val colors = listOf(Color(0xFF4CAF50), Color(0xFF1A1A1A)) // Define your gradient colors

            // Create a linear gradient brush
            val gradientBrush = Brush.horizontalGradient(colors)
            Image(
                painter = rememberAsyncImagePainter("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Bitcoin_logo.svg/2560px-Bitcoin_logo.svg.png"),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .graphicsLayer {
                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                    }
                    .height(190.dp)
                    .fillMaxWidth().background(gradientBrush)
            )
            }

        items(state.data) { coin ->
            CoinListItem(coin = coin,
                onItemClick = { navController.navigate(ScreenRoutes.CoinsDetailScreen.route + "/${coin.id}") })
        }
    }



    if (state.isLoading) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
    if (state.error.isNotEmpty()) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = state.error)
        }
    }


}


