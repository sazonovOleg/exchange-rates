package com.example.exchangesrate.infrastructure.utils

object Utils {
    fun stringSplitToMap(string: String, stringDelimiter: String, mapDelimiter: String) {
        string.split(",")
            .map { it.split("=") }.associate { it.first() to it.last().toInt() }
    }
}