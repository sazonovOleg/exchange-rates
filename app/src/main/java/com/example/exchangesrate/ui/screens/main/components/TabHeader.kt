package com.example.exchangesrate.ui.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exchangesrate.R

@Composable
fun TabHeader(
    textId: Int,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(vertical = 20.dp, horizontal = 10.dp)
    ) {
        Text(
            stringResource(
                id = textId,
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Button(onClick = { onClick() }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    stringResource(id = R.string.sort_by).uppercase(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Image(
                    painterResource(R.drawable.sort),
                    contentDescription = "prev_btn_slide",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
        }
    }
}