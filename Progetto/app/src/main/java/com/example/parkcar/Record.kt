package com.example.parkcar

import java.util.Calendar
import java.util.Date

class Record( private val name: String, private val long: Double,private val lat: Double) {

    fun getLong() : Double { return long }
    fun getLat() : Double { return lat }
    fun getName() : String { return name }
    fun getDate() : String {
        val calendar = Calendar.getInstance()
        return calendar.time.toString()
    }

}