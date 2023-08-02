package com.example.exchangesrate.infrastructure.repo

import android.content.Context
import android.util.Log
import com.example.exchangesrate.domain.ApiService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
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

    suspend fun getJsonFromApi(context: Context, keyJsonEl: String): String {
        return Json.parseToJsonElement(getApiCurrency(context).toString()).jsonObject[keyJsonEl].toString()
    }
}