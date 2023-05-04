package com.tunein.radiotime.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

import dagger.hilt.android.AndroidEntryPoint

import com.tunein.radiotime.MainViewModel
import com.tunein.radiotime.common.theme.RadiotimeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @Composable
    private fun MainContent() {
        val viewModel: MainViewModel = hiltViewModel()
        val uiState = viewModel.uiState.collectAsState()

        RadiotimeTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainScreen(uiState.value.mainState)
            }
        }
    }
}