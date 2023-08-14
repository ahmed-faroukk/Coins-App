package com.farouk.compose_mvvm_cleanarch.presentation.coindetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.farouk.compose_mvvm_cleanarch.data.remote.dto.TeamMember

@Composable
fun TeamMemberItem(
    name :String,
    job : String
){
    Column(Modifier.fillMaxWidth()) {
        Text(text = name , fontWeight = FontWeight.Bold , color = Color.White)
        Text(text = job, color = Color.White)
    }
}