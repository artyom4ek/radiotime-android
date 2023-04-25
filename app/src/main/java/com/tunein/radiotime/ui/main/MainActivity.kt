package com.tunein.radiotime.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.tunein.common.theme.RadiotimeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RadiotimeTheme {
                MainScreen()
            }
        }
    }
}