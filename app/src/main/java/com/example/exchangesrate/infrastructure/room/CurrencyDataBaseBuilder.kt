package com.example.exchangesrate.infrastructure.room

import android.content.Context
import androidx.room.Room

object CurrencyDataBaseBuilder {
    fun createDatabase(applicationContext: Context): CurrencyDatabase {
        return Room.databaseBuilder(
            applicationContext,
            CurrencyDatabase::class.java, "currency_database"
        ).build()
    }
}