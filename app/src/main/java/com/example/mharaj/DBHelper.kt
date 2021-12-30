package com.example.mharaj

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.graphics.createBitmap
import com.example.mharaj.Models.orderModel
import java.lang.Exception

class DBHelper(context: Context) : SQLiteOpenHelper(context,"food.db",null,1)
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
        values.put("foodname",foodname)
        values.put("description",desc)
        values.put("quantity",quantity)

        var id:Long = database.insert("orders",null,values)
        return id > 0
    }
    @SuppressLint("Range")
     fun getOrders():ArrayList<orderModel>
    {
        var orderList = ArrayList<orderModel>()
        val selestQuery = "SELECT foodname,image FROM orders"
        val database = this.writableDatabase
        val cursor:Cursor?
        try {
            cursor = database.rawQuery(selestQuery,null)
        }catch (e:Exception)
        {
            e.printStackTrace()
            database.execSQL(selestQuery)
            return ArrayList()
        }

        if(cursor.moveToFirst())
        {
            do {
                orderList.add(orderModel(cursor.getInt(cursor.getColumnIndex("image")),cursor.getString(cursor.getColumnIndex("foodname"))))
                // Not getting food name
            }while (cursor.moveToNext())
        }
        cursor.close()
        return orderList
    }
}