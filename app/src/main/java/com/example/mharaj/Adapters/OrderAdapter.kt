package com.example.mharaj.Adapters

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mharaj.Models.mainModel
import com.example.mharaj.Models.orderModel
import com.example.mharaj.R

class OrderAdapter(context: Context ,private val orderlist: ArrayList<orderModel>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var orderfoodImg = itemView.findViewById<ImageView>(R.id.img)
        var ordername = itemView.findViewById<TextView>(R.id.ordername)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.order_grid_view,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val ordermodel:orderModel = orderlist.get(position)
        holder.orderfoodImg.setImageResource(ordermodel.orderimage)
        holder.ordername.setText(ordermodel.ordername)
    }

    override fun getItemCount(): Int
    {
        return orderlist.size
    }

}