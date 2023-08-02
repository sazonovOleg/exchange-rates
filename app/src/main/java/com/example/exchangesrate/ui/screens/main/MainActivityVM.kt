package com.example.exchangesrate.ui.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangesrate.infrastructure.repo.DataBaseRepo
import com.example.exchangesrate.infrastructure.room.CurrencyData
import com.example.exchangesrate.infrastructure.room.CurrencyDataBaseBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine

data class MainActivityData(
    var isSortWindowShow: Boolean = false,
    var mutableDataBase: MutableList<CurrencyData> = mutableListOf()
)

class MainActivityVM(application: Application) : AndroidViewModel(application) {
    private val _screenState = MutableStateFlow(MainActivityData())

    val screenState: StateFlow<MainActivityData> get() = _screenState.asStateFlow()

    fun showSortWindow(isShow: Boolean) {
        _screenState.tryEmit(_screenState.value.copy(isSortWindowShow = isShow))
    }

//    suspend fun getDataBase(): MutableList<String> = suspendCancellableCoroutine { emitter ->
//        var mutableList: MutableList<String> = mutableListOf()
//
//        if (emitter.isActive) {
//            val dataBase =  DataBaseRepo(getApplication()).getDataBase()
//            dataBase.forEach {
//                mutableList = it.currency
//            }.apply {
//                _screenState.tryEmit(_screenState.value.copy(mutableDataBase = mutableList))
//            }
//            emitter.resumeWith(Result.success(
//                _screenState.value.mutableDataBase
//            ))
//        }
//    }
    init {
        viewModelScope.launch {
            //        val output = s.split(",")
//            .map { it.split("=") }
//            .map { it.first() to it.last().toInt() }
//            .toMap()
            //Loader на 5 секунд
            DataBaseRepo(getApplication()).getDataBase(getApplication()).forEach {
                Log.d("Devv", "Devv suspend db = ${it.rates}")
            }
        }
    }
}