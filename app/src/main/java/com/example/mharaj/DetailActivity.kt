package com.example.mharaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = intent.getIntExtra("image",0)
        val price = intent.getStringExtra("price")!!.toInt()
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("desc")

        var foodimageview = findViewById<ImageView>(R.id.foodDetailImg)
        var fooddetailprice = findViewById<TextView>(R.id.detailfoodprice)
        var foodname = findViewById<TextView>(R.id.foodDetailName)
        var fooddetaildesc = findViewById<TextView>(R.id.detailDescreption)
        val quantity = findViewById<TextView>(R.id.quantity)

        foodimageview.setImageResource(image)
        fooddetailprice.setText(price.toString())
        foodname.setText(name)
        fooddetaildesc.setText(description)
//        var qnt:Int = Integer.parseInt(quantity.toString())

//        var helper = DBHelper(this)
//        val orderbutton = findViewById<Button>(R.id.orderButton)
//
//        val personName = findViewById<TextView>(R.id.editTextTextPersonName)
//        val personPhone = findViewById<TextView>(R.id.editTextPhone)
//        orderbutton.setOnClickListener()
//        {
//            val isInserted:Boolean = helper.insertOrder(personName.toString(),personPhone.toString(),price,image,name.toString(),description.toString(),qnt)
//            if(isInserted)
//            {
//                Toast.makeText(this,"Data Success",Toast.LENGTH_SHORT).show()
//            }
//            else
//            {
//                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}