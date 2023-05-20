package com.tunein.radiotime.ui.main

import javax.inject.Inject

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

import com.tunein.radiotime.common.theme.RadiotimeTheme
import com.tunein.radiotime.navigation.Navigator

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(navigator)
        }
    }

    @Composable
    private fun MainContent(navigator: Navigator) {
        val mainViewModel: MainViewModel = hiltViewModel()

        RadiotimeTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainScreen(
                    navigator = navigator,
                    mainViewModel = mainViewModel,
                    onPlayClick = { mainViewModel.setEvent(MainContract.Event.PlayAudio(it)) },
                    onClosePlayerBar = { mainViewModel.setEvent(MainContract.Event.StopAudio) },
                    onReleasePlayer = { mainViewModel.setEvent(MainContract.Event.ReleasePlayer) }
                )
            }
        }
    }
}