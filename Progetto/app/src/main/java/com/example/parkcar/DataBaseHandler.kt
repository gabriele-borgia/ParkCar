package com.example.parkcar

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

private val DATABASE_NAME = "MyBD"
private val TABLE_NAME = "park"

private val COL_ID = "id"
private val COL_NAME = "name"
private val COL_LONG = "longitudine"
private val COL_LAT = "latitudine"
private val COL_DATA = "data"


class DataBaseHandler(var context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+ TABLE_NAME+"("+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_NAME+" VARCHAR(256), "+
                COL_LONG + " VARCHAR(256)," + COL_LAT + " VARCHAR(256),"+ COL_DATA +" DATETIME);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertRecord(record : Record){
        val db = this.writableDatabase
        var cv = ContentValues().apply {
            put(COL_NAME,record.getName())
            put(COL_LONG,record.getLong())
            put(COL_LAT,record.getLat())
            put(COL_DATA,record.getDate())
        }

        val newRowId = db?.insert(TABLE_NAME, null, cv)

        if(newRowId == -1.toLong()) Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show()
        else Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
    }

    fun readRecord() : MutableList<Record>{
        var list : MutableList<Record> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM "+ TABLE_NAME
        val result = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do{
                var record = Record()
                record.setId(result.getString(0).toInt())
                record.setName( result.getString(1))
                record.setLong(result.getString(2).toDouble())
                record.setLat(result.getString(3).toDouble())
                record.setData(result.getString(4))

                list.add(record)
            }while(result.moveToNext())
        }
        db.close()
        result.close()
        return list
    }
    }
