package com.example.exchangesrate.infrastructure.repo

import android.content.Context
import android.util.Log
import com.example.exchangesrate.infrastructure.room.CurrencyData
import com.example.exchangesrate.infrastructure.room.CurrencyDataBaseBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DataBaseRepo(val context: Context) {
    private val db = CurrencyDataBaseBuilder.createDatabase(context)
    suspend fun createDataBase() = coroutineScope {
        launch(Dispatchers.IO) {
            val apiSR = ApiServiceRepo()
            val time = apiSR.getLatestTime(context)
            val currencyData = apiSR.getCurrencyList(context)
            val currencyTypeData = apiSR.getCurrencyTypeList(context)
            db.currencyDao().addToData(CurrencyData(time, currencyTypeData, currencyData))

            Log.d("devv", "Devv currencyData = $currencyData")
            Log.d("devv", "Devv currencyTypeData = $currencyTypeData")

            val currencyDataList = db.currencyDao().getDataList()

            for (cd in currencyDataList) {
                Log.d("devv", "devv last_update_date = ${cd.last_update_date}")
                Log.d("devv", "devv currency = ${cd.currency}")
                Log.d("devv", "devv currencyType = ${cd.currencyType}")
            }
        }
    }
}