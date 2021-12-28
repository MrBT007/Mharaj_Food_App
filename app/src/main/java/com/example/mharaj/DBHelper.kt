package com.example.mharaj

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,"mydb.db",null,1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL("create table orders"+
            "(id integer primary key autoincrement,"+
            "name text,"+
            "phone text,"+
            "price int,"+
            "image int,"+
            "description text,"+ "quantity int,"+
            "foodname text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int)
    {
        db?.execSQL("DROP table if exists orders")
        onCreate(db)
    }
    fun insertOrder(name:String,phone:String,price:Int,image:Int,desc:String,foodname:String,quantity:Int):Boolean
    {
        var database:SQLiteDatabase = readableDatabase
        var values:ContentValues = ContentValues()
        values.put("name",name)
        values.put("phone",phone)
        values.put("price",price)
        values.put("image",image)
        values.put("description",desc)
        values.put("foodname",foodname)
        values.put("quantity",quantity)
        var id:Long = database.insert("orders",null,values)
        return id > 0
    }
}