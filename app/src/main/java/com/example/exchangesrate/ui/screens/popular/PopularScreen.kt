package com.example.exchangesrate.ui.screens.popular

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.exchangesrate.R
import com.example.exchangesrate.ui.screens.main.components.TabBody
import com.example.exchangesrate.ui.screens.main.components.TabHeader

@Composable
fun PopularScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        TabHeader(textId = R.string.currency_selection) {
            Log.d("Devv", "Devv onClick TabHeader")
        }
        TabBody {
            Log.d("Devv", "devv iconItemClick TabList")
        }
    }
}