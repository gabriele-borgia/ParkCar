package com.example.parkcar

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VisualizzaDB : AppCompatActivity() {

    val context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizza)
        start(context, findViewById<LinearLayout>(R.id.containerLayout))
    }

    private fun start(context : Context, layout : LinearLayout){
        val lettura = LetturaDB(context)
        lettura.dbVisual(layout)
    }
}