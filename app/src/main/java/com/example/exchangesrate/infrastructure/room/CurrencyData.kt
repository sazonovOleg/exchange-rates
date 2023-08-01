package com.example.exchangesrate.infrastructure.room

import androidx.room.Entity
import androidx.room.PrimaryKey

//обновлять базу, если ошибка использовать посл значения
//TODO доделать базу и заполнение из json файла
//@ColumnInfo(name = "published_author")
//var author: String
//var rates: Map<String, String>,


@Entity(tableName = "ex_change_rate_db")
data class CurrencyData(
    @PrimaryKey(autoGenerate = false)
    var last_update_date: String,

    var currencyType: MutableList<String>,
    var currency: MutableList<String>,
)

data class Rates(
    var currency: String,
    var currencyType: String,
)