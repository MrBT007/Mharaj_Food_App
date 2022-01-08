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
        val type = intent.getIntExtra("type",1)
        var helper = DBHelper(this)


        var foodimageview = findViewById<ImageView>(R.id.foodDetailImg)
        var fooddetailprice = findViewById<TextView>(R.id.detailfoodprice)
        var foodname = findViewById<TextView>(R.id.foodDetailName)
        var fooddetaildesc = findViewById<TextView>(R.id.detailDescreption)
        var quantity = findViewById<TextView>(R.id.quantity)
        var add = findViewById<ImageView>(R.id.add)
        var subtract = findViewById<ImageView>(R.id.subtract)

        foodimageview.setImageResource(image)
        fooddetailprice.setText(price.toString())
        foodname.setText(name)
        fooddetaildesc.setText(description)
        var qnt = quantity.text.toString()

        val orderbutton = findViewById<Button>(R.id.orderButton)

        val personName = findViewById<TextView>(R.id.editTextTextPersonName)
        val personPhone = findViewById<TextView>(R.id.editTextPhone)

        var a = qnt.toInt()
        add.setOnClickListener()
        {
            a++
            qnt = (a).toString()
            quantity.text = qnt
        }
        subtract.setOnClickListener()
        {
            if (a >= 2) {
                a = a - 1
                qnt = (a).toString()
                quantity.text = qnt
            }
        }

        orderbutton.setOnClickListener()
        {
            val isInserted: Boolean = helper.insertOrder(
                personName.text.toString(),
                personPhone.text.toString(),
                price,
                image,
                description.toString(),
                name.toString(),
                qnt.toInt()
            )
            if (isInserted) {
                Toast.makeText(this, "Data Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}