package com.example.mharaj.Models

class orderModel
{
    val quantity:Int
    var price :Int
    val img:Int


    constructor(quantity:Int , price:Int,img:Int)
    {
        this.quantity = quantity
        this.price = price*quantity
        this.img = img
    }
}