package com.farouk.compose_mvvm_cleanarch

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import com.farouk.compose_mvvm_cleanarch.presentation.components.AppNavigation
import com.farouk.compose_mvvm_cleanarch.ui.theme.ComposemvvmcleanArchTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalLayoutApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            // Apply system UI changes
            systemUiController.setStatusBarColor(Color.Black)
            systemUiController.setNavigationBarColor(Color.Black)
                Column(Modifier.fillMaxSize().background(Color.Black)) {
                    AppNavigation()
            }
        }


    }
}

