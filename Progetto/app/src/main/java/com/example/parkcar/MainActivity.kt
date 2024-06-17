package com.example.parkcar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupButtonMainActivity(context)
    }

    private fun setupButtonMainActivity(context: Context) {



            findViewById<Button>(R.id.btn_insert).setOnClickListener {
                val name = findViewById<EditText>(R.id.edt_name)
                val long = findViewById<EditText>(R.id.edt_long)
                val lat = findViewById<EditText>(R.id.edt_lat)
                if(name.text.toString().isNotEmpty()&& long.text.isNotEmpty()&& lat.text.isNotEmpty()){
                    var record = Record(name.text.toString(),long.text.toString().toDouble(), lat.text.toString().toDouble())
                    var db = DataBaseHandler(context)
                    db.insertRecord(record)
                    name.text.clear()
                    long.text.clear()
                    lat.text.clear()
                    name.requestFocus()

                } else {
                    Toast.makeText(context,"Inserire dei valori validi", Toast.LENGTH_SHORT).show()
                }
            }

            findViewById<Button>(R.id.btn_read).setOnClickListener {
                val intent = Intent(this, VisualizzaDB::class.java)
                startActivity(intent)
            }

        }
}