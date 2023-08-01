//package com.example.exchangesrate.infrastructure.provider
//
//import android.content.Context
//import android.util.Log
//import com.example.exchangesrate.domain.ApiService
//
//object ProviderService {
//    private var apiService: ApiService? = null
//
//    init {
//        apiService = ApiService()
//    }
//
//    suspend fun getApiCurrency(context: Context) {
//        apiService!!.getJsonFromApi(context)
//        Log.d("devv", "devv getJsonFromApi = ${apiService!!.getJsonFromApi(context)}")
//    }
//
//    fun getAssetsCurrency(context: Context) {
//        apiService!!.getJsonFromAssets(context)
//        Log.d("devv", "devv getJsonFromAssets = ${apiService!!.getJsonFromAssets(context)}")
//    }
//
//    fun getFullCountryName() {
//
//    }
//}