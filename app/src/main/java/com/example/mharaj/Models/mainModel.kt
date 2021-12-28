package com.example.mharaj.Models

class mainModel
{
    val image:Int
    val name :String
    val descreption :String
    val orderprice:String

    constructor(image:Int , name:String, orderprice:String, descreption:String)
    {
        this.image = image
        this.name = name
        this.orderprice = orderprice
        this.descreption = descreption
    }
}