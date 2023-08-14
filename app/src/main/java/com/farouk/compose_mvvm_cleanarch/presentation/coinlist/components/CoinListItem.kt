package com.farouk.compose_mvvm_cleanarch.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.farouk.compose_mvvm_cleanarch.domin.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(coin)
            }.padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween ,

    ) {

        Text(
            text = "${coin.rank}.${coin.name} (${coin.symbol})",
            fontWeight = FontWeight.Bold, color = Color.White , textAlign = TextAlign.Start)

        Text(
            text = if (coin.is_active) "Active" else "InActive",
            color = if (coin.is_active) Color.Green else Color.Red,
            style = TextStyle.Default ,
            textAlign = TextAlign.End
        )

    }

}