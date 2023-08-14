package com.farouk.compose_mvvm_cleanarch.presentation.coindetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farouk.compose_mvvm_cleanarch.presentation.components.ScreenRoutes

@Composable
fun CoinTagItem(
        tag : String
){

    Box(
        Modifier
            .border(
                width = 1.dp,
                color = Color.Green,
                shape = RoundedCornerShape(100.dp)
            ).padding(5.dp)
    ) {
        Text(text = tag , color = Color.Green , fontWeight = FontWeight.Bold)
    }

}