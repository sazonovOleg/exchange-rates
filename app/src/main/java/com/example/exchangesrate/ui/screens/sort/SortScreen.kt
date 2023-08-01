package com.example.exchangesrate.ui.screens.sort

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exchangesrate.R
import com.example.exchangesrate.ui.screens.main.MainActivityVM

@Composable
fun SortingWindow(vm: MainActivityVM = viewModel()) {
    Box(
        modifier = Modifier
            .background(Color(0x80242424))
            .zIndex(1f)
            .fillMaxSize(1f),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.8f)
                .background(Color(0xFF0022FF))
        ) {
            IconButton(onClick = {
                vm.showSortWindow(false)
            }) {
                Image(
                    painterResource(R.drawable.close_icon),
                    modifier = Modifier.width(30.dp).height(30.dp),
                    contentDescription = "close_button",
                )
            }
            Text(
                text = "Сортировать по",
                color = Color(0xFFFFFFFF)
            )
            Text(
                text = "алфафиту",
                color = Color(0xFFFFFFFF)
            )
            Text(
                text = "значению",
                color = Color(0xFFFFFFFF)
            )
        }
    }
}