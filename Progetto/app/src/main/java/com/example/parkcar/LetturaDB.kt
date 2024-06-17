package com.example.parkcar

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class LetturaDB(val context : Context) {

    fun dbVisual(layout: LinearLayout){
        var db = DataBaseHandler(context) //Creazione istanza del gestore del database
        var list: MutableList<Record> = db.readRecord() //lettura dei record nel database e memorizzazione in una lista mutabile

        for (i in 0 .. (list.size -1)){
            val inflater = LayoutInflater.from(context)
            val customView = inflater.inflate(R.layout.record_view, layout, false)

            val name = customView.findViewById<TextView>(R.id.name)
            val long = customView.findViewById<TextView>(R.id.longitude)
            val lat = customView.findViewById<TextView>(R.id.latitude)
            val data = customView.findViewById<TextView>(R.id.data)


            name.text = list.get(i).getName()
            long.text = list.get(i).getLong().toString()
            lat.text = list.get(i).getLat().toString()
            data.text = list.get(i).getDate()

            layout.addView(customView)
        }
    }

}