package com.example.exchangesrate.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exchangesrate.R
import com.example.exchangesrate.ui.screens.main.MainActivityVM
import kotlinx.coroutines.launch

@Composable
fun TabBody(
    vm: MainActivityVM = viewModel(),
    iconOnClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(1f)
            .heightIn(max = 400.dp)
            .padding(horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.Start,
            ) {
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = "Валюта",
                    fontSize = 18.sp,
                )
                Text(
                    text = "Значение",
                    fontSize = 18.sp,
                )
            }
            IconButton(
                onClick = { iconOnClick() },
                content = {
                    Image(
                        painterResource(R.drawable.star),
                        contentDescription = "prev_btn_slide",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp)
                    )
                }
            )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth(1f)
            .height(2.dp)
            .background(Color(0xFFFF0000)))
    }
}