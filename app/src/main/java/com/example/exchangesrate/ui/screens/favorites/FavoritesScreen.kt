package com.example.exchangesrate.ui.screens.favorites

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exchangesrate.R
import com.example.exchangesrate.ui.screens.main.MainActivityVM
import com.example.exchangesrate.ui.screens.main.components.TabBody
import com.example.exchangesrate.ui.screens.main.components.TabHeader

@Composable
fun FavoritesScreen(vm: MainActivityVM = viewModel()) {
    Column(
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        TabHeader(textId = R.string.currency_selection) {
            vm.showSortWindow(true)
        }
        TabBody {
            Log.d("Devv", "devv iconItemClick")
        }
    }
}