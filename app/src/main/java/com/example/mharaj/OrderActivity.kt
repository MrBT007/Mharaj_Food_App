package com.example.mharaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mharaj.Adapters.OrderAdapter
import com.example.mharaj.Models.orderModel

class OrderActivity : AppCompatActivity()
{
    var orderlist = arrayListOf<orderModel>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var gridView = findViewById<GridView>(R.id.OrdergridView)

        orderlist.add(orderModel(R.drawable.vadapav,"Vada-Pav"))
        orderlist.add(orderModel(R.drawable.pizza,"Pizza"))
        orderlist.add(orderModel(R.drawable.olorotlo,"Olo-Rotlo"))
        orderlist.add(orderModel(R.drawable.dabeli,"Dabeli"))
        orderlist.add(orderModel(R.drawable.dabeli,"Dabeli"))
        orderlist.add(orderModel(R.drawable.samosa,"Samosa"))
        orderlist.add(orderModel(R.drawable.samosa,"Samosa"))
        orderlist.add(orderModel(R.drawable.samosa,"Samosa"))
        orderlist.add(orderModel(R.drawable.samosa,"Samosa"))
        orderlist.add(orderModel(R.drawable.sandwich,"Sandwich"))
        orderlist.add(orderModel(R.drawable.puff,"Puff"))
        orderlist.add(orderModel(R.drawable.puff,"Puff"))
        orderlist.add(orderModel(R.drawable.puff,"Puff"))
        orderlist.add(orderModel(R.drawable.burger,"Burger"))

    }
}