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
        var database:SQLiteDatabase = writableDatabase
        var values:ContentValues = ContentValues()
        values.put("name",name)
        values.put("phone",phone)
        values.put("price",price)
        values.put("image",image)
        values.put("description",desc)
        values.put("quantity",quantity)
        values.put("foodname",foodname)

        var id:Long = database.insert("orders",null,values)
        return id > 0
    }
    @SuppressLint("Range")

    var orderList = ArrayList<orderModel>()
     @SuppressLint("Range")
     fun getOrders():ArrayList<orderModel>
    {
        val selestQuery = "SELECT quantity,price,image FROM orders"
        val database = this.writableDatabase
        val cursor:Cursor = database.rawQuery(selestQuery,null)

        if(cursor.moveToFirst())
        {
            do {
                orderList.add(orderModel(cursor.getInt(cursor.getColumnIndex("quantity")),cursor.getInt(cursor.getColumnIndex("price")),cursor.getInt(cursor.getColumnIndex("image"))))
            }while (cursor.moveToNext())
        }
        return orderList
    }

}