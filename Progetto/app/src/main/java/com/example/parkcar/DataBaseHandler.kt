package com.example.parkcar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DATABASE_NAME = "MyBD"
private val TABLE_NAME = "Park"
private val COL_LONG = "longitudine"
private val COL_LAT = "latitudine"
private val COL_NAME = "name"
private val COL_ID = "id"
private val COL_DATA = "data"


class DataBaseHandler(var context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE "+ TABLE_NAME+"("+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_NAME+" VARCHAR(256), "+
                COL_LONG + " FLOAT" + COL_LAT + "FLOAT"+ COL_DATA +"DATETIME);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}