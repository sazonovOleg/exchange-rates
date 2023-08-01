package com.example.exchangesrate.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.exchangesrate.ui.screens.main.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: MainActivityVM by viewModels()

        setContent {
            MainScreen(vm)
        }
    }
}