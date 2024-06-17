package com.example.parkcar

import java.util.Calendar
import java.util.Date

class Record{

    private var id : Int = 0;
    private var name : String = ""
    private var long : Double = 0.00
    private var lat : Double = 0.00
    private var data : String = ""
    private val calendar = Calendar.getInstance()
    constructor(){}

    constructor(name: String, long: Double,lat: Double){
        this.name = name
        this.long = long
        this.lat = lat
        this.data = calendar.time.toString()
    }

    fun getLong() : String { return long.toString() }
    fun getLat() : String { return lat.toString() }
    fun getName() : String { return name }
    fun getDate() : String { return data }

    fun setId(id : Int){this.id = id}
    fun setName(name : String){ this.name = name}
    fun setLong(long : Double){ this.long = long }
    fun setLat(lat : Double){this.lat = lat}
    fun setData(data : String){ this.data = data}



}