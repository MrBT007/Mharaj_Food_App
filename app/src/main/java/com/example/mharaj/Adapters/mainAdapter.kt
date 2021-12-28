package com.example.mharaj.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mharaj.Models.mainModel
import com.example.mharaj.R


class mainAdapter(private val list: ArrayList<mainModel>, var clickListener: onItemClickListener) : RecyclerView.Adapter<mainAdapter.viwholder>()
{
    inner class viwholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val foodimage:ImageView = itemView.findViewById(R.id.imageView)
        val mainName:TextView = itemView.findViewById(R.id.name)
        val descreption:TextView = itemView.findViewById(R.id.descreption)
        val orderprice:TextView = itemView.findViewById(R.id.orderPrice)

        fun initialize(item:mainModel,action: onItemClickListener)
        {
            foodimage.setImageResource(item.image)
            mainName.setText(item.name)
            descreption.setText(item.descreption)
            orderprice.setText(item.orderprice)

            itemView.setOnClickListener()
            {
                action.onCLick(item,adapterPosition)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viwholder
    {
        return viwholder(LayoutInflater.from(parent.context).inflate(R.layout.sample_layout,parent,false))
    }

    override fun onBindViewHolder(holder: viwholder, position: Int) {
//        val model:mainModel = list.get(position)
//        holder.foodimage.setImageResource(model.image)
//        holder.mainName.setText(model.name)
//        holder.descreption.setText(model.descreption)
//        holder.orderprice.setText(model.orderprice)
        holder.initialize(list.get(position),clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface onItemClickListener
{
    fun onCLick(item:mainModel,position: Int)
}
