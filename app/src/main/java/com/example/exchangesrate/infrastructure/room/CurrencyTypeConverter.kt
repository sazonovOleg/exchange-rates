package com.example.exchangesrate.infrastructure.room

import android.util.Log
import androidx.room.TypeConverter

class CurrencyTypeConverter {
    @TypeConverter
    fun fromList(listOfString: MutableList<String>): String {
        return listOfString.toString()
    }

    @TypeConverter
    fun toList(listOfString: String): MutableList<String> {
        return listOfString.split("=").toMutableList()
    }
//    @TypeConverter
//    fun fromListRates(ratesList: Map<String, String>): String {
//        return ratesList.toString()
//    }
//
//    @TypeConverter
//    fun toListRates(ratesString: String): Map<String, String> {
//        Log.d("devv", "devv what in ratesString = $ratesString")
//        return ratesString
//            .split(",")
//            .map { it.split(":") }
//            .associate { it.first() to it.last() }.toMap()
//    }
}