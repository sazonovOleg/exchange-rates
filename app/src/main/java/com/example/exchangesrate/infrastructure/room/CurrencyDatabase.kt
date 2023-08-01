package com.example.exchangesrate.infrastructure.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CurrencyData::class], version = 1)
@TypeConverters(CurrencyTypeConverter::class)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}







///
//    companion object {
//        @Volatile
//        private var instance: CurrencyDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: createDatabase(context).also { instance = it }
//        }
//
//        private fun createDatabase(context: Context): CurrencyDatabase {
//            return Room.databaseBuilder(
//                context,
//                CurrencyDatabase::class.java, "currency_database"
//            ).build()
//        }
//    }