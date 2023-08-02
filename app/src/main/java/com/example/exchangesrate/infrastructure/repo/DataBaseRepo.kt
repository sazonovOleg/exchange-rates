package com.example.exchangesrate.infrastructure.repo

import android.content.Context
import android.util.Log
import com.example.exchangesrate.infrastructure.room.CurrencyData
import com.example.exchangesrate.infrastructure.room.CurrencyDataBaseBuilder
import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

class DataBaseRepo(val context: Context) {
    private val db = CurrencyDataBaseBuilder.createDatabase(context)
    private val apiSR = ApiServiceRepo()


    private suspend fun createDataBase() = coroutineScope {
        launch(Dispatchers.IO) {
            val rates = apiSR.getJsonFromApi(context, keyJsonEl = "rates")
            val date = apiSR.getJsonFromApi(context, keyJsonEl = "date")
            val timestamp = apiSR.getJsonFromApi(context, keyJsonEl = "timestamp")

            db.currencyDao().addToData(
                CurrencyData(
                    timestamp = timestamp,
                    date = date,
                    rates = rates
                )
            )
        }
    }

    suspend fun getDataBase(context: Context): List<CurrencyData> {
        //Допилить короутинки чтобы база дожидалась ответа
        DataBaseRepo(context).createDataBase()
        return db.currencyDao().getDataList()
    }
}