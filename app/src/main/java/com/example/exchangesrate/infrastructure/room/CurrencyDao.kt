package com.example.exchangesrate.infrastructure.room

import androidx.room.*

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToData(currencyData: CurrencyData)

    @Query("SELECT * FROM ex_change_rate_db")
    fun getDataList(): List<CurrencyData>

    @Update
    suspend fun updateData(currencyData: CurrencyData)

    @Update
    suspend fun deleteData(currencyData: CurrencyData)
}