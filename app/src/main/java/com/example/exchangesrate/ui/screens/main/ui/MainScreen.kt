package com.example.exchangesrate.ui.screens.main.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exchangesrate.ui.screens.main.MainActivityVM
import com.example.exchangesrate.ui.screens.main.components.Tabs
import com.example.exchangesrate.ui.screens.sort.SortingWindow
import com.example.exchangesrate.ui.theme.ExchangesrateTheme

@Composable
fun MainScreen(vm: MainActivityVM = viewModel()) {
    val screenState = vm.screenState.collectAsState().value

    if (screenState.isSortWindowShow) {
        SortingWindow()
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFFE5E5),
                        Color(0xB9E1D4FF),
                    )
                )
            )
    ) {
        Log.d("Devv", "devv screenState = ${screenState.isSortWindowShow}")
        Tabs()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExchangesrateTheme {
        MainScreen()
    }
}