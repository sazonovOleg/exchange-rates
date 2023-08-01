package com.example.exchangesrate.ui.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.exchangesrate.infrastructure.room.CurrencyDataBaseBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainActivityData(
    var isSortWindowShow: Boolean = false
)

class MainActivityVM(application: Application) : AndroidViewModel(application) {
    private val _screenState = MutableStateFlow(MainActivityData())

    val screenState: StateFlow<MainActivityData> get() = _screenState.asStateFlow()

    fun showSortWindow(isShow: Boolean) {
        _screenState.tryEmit(_screenState.value.copy(isSortWindowShow = isShow))
    }
}