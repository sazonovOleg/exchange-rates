package com.example.exchangesrate.infrastructure.repo

import android.content.Context
import android.util.Log
import com.example.exchangesrate.domain.ApiService
import org.json.JSONObject

//TODO получать timeStamp для обновления базы
class ApiServiceRepo {
    private var apiService: ApiService? = null

    init {
        apiService = ApiService()
    }

    private suspend fun getApiCurrency(context: Context): JSONObject {
        return apiService!!.getJsonFromApi(context)
    }

    fun getAssetsCurrency(context: Context) {
        apiService!!.getJsonFromAssets(context)
    }

    suspend fun getCurrencyTypeList(context: Context): MutableList<String> {
        val currencyTypeList = mutableListOf<String>()

        val jsonObj = getApiCurrency(context)["rates"].toString()
            .replace("{", "")
            .replace("}", "")

        Log.d("Devv", "devv jsonObj rates = $jsonObj")

        jsonObj.split(",")
            .map { it.split(":") }
            .associate { it.first() to it.last() }.toMap().forEach {
                currencyTypeList.add(it.key)
            }

        return currencyTypeList
    }

    suspend fun getCurrencyList(context: Context): MutableList<String> {
        val currencyList = mutableListOf<String>()

        val jsonObj = getApiCurrency(context)["rates"].toString()
            .replace("{", "")
            .replace("}", "")

        jsonObj.split(",")
            .map { it.split(":") }
            .associate { it.first() to it.last() }.toMap().forEach {
                currencyList.add(it.value)
            }

        return currencyList
    }

    suspend fun getLatestTime(context: Context): String {
        return getApiCurrency(context)["date"].toString()
    }

    suspend fun getTimestamp(context: Context): Long {
        return getApiCurrency(context)["timestamp"].toString().toLong()
    }
}