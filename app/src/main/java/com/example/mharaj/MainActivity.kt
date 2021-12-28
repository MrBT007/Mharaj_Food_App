package com.example.mharaj

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mharaj.Adapters.mainAdapter
import com.example.mharaj.Adapters.onItemClickListener
import com.example.mharaj.Models.mainModel
import java.util.ArrayList

class MainActivity : AppCompatActivity(),onItemClickListener
{
    val list = arrayListOf<mainModel>()
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        list.add(mainModel(R.drawable.burger,"Burger","49","Steamed potatoes, carrots, French beans, Garlic, ginger and green chilies"))
        list.add(mainModel(R.drawable.pizza,"Pizza","129","Pizza sauce, black olive, cheese, oil, oregano, toppings"))
        list.add(mainModel(R.drawable.fries,"French Fries","39","Fried Potato strips, sauce, cheese"))
        list.add(mainModel(R.drawable.sandwich,"Sandwich","20","Bread, cheese, tomatoes, onion, butter, sauce, oregano"))
        list.add(mainModel(R.drawable.samosa,"Samosa","25","Streamed potatoes, spices, sauce"))
        list.add(mainModel(R.drawable.dabeli,"Dabeli","13","Streamed potatoes, bread, spices, sauce, green sauce"))
        list.add(mainModel(R.drawable.vadapav,"Vada Pav","13","Vada, bread, spices, sauce, green sauce"))
        list.add(mainModel(R.drawable.puff,"Puff","15","Streamed potatoes, light pastry, sauce, green sauce"))
        list.add(mainModel(R.drawable.olorotlo,"Olo-Rotlo","99","Olo, Rotlo"))

        val linearLayoutManager = LinearLayoutManager(this)
        val mainadapter = mainAdapter(list,this)
        recyclerview.adapter = mainadapter
        recyclerview.layoutManager = linearLayoutManager

        val aboutme = findViewById<ImageView>(R.id.about)
        aboutme.setOnClickListener()
        {
            val intent = Intent(this,aboutMe::class.java)
            startActivity(intent)
        }
    }

    override fun onCLick(item: mainModel, position: Int)
    {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("image",item.image)
        intent.putExtra("price",item.orderprice)
        intent.putExtra("name",item.name)
        intent.putExtra("desc",item.descreption)
        startActivity(intent)
    }
}