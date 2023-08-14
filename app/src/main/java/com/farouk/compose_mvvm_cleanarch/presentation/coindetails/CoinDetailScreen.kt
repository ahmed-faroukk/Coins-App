package com.farouk.compose_mvvm_cleanarch.presentation.coindetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farouk.compose_mvvm_cleanarch.presentation.coindetails.components.CoinTagItem
import com.farouk.compose_mvvm_cleanarch.presentation.coindetails.components.TeamMemberItem

@ExperimentalLayoutApi
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value
    state.data?.let {
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .padding(top = 12.dp)
                .fillMaxSize()
                .padding(5.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${it.rank}. ${it.name}(${it.symbol})",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = if (it.isActive) "active" else "inActive",
                        fontWeight = FontWeight.Bold,
                        color = if (it.isActive) Color.Green else Color.Red
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
                Text(text = it.description, fontWeight = FontWeight.Light, color = Color.White)
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
                Text(
                    text = "Tags",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )

                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    it.tags.forEach { tag->
                        CoinTagItem(tag = tag)
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )

                Text (
                    text = "Team Member",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                )
            }
            items(it.team){ member->
                TeamMemberItem(name = member.name, job = member.position )
                Divider()
            }


        }
    }
    if (state.isLoading) {
        CircularProgressIndicator()
    }
    if (state.error.isNotEmpty()) {
        Text(text = state.error, textAlign = TextAlign.Center, color = Color.Red)
    }

}