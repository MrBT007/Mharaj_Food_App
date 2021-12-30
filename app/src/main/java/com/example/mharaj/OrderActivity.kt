package com.example.mharaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mharaj.Adapters.OrderAdapter
import com.example.mharaj.Models.orderModel

class OrderActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderrecyclerview = findViewById<RecyclerView>(R.id.orderRecyclerView)
        var dbHelper = DBHelper(this)
        var orderlist:ArrayList<orderModel> = dbHelper.getOrders()

        var gridLayoutManager = GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
        orderrecyclerview.layoutManager = gridLayoutManager
        orderrecyclerview.setHasFixedSize(true)
        var orderAdapter = OrderAdapter(applicationContext,orderlist)
        orderrecyclerview.adapter = orderAdapter
    }
}