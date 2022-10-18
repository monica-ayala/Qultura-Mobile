package com.example.qulturapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.viewmodel.list.ViewHolder

class ViewPagerAdapter(var context: Context): RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    var color_matrix = arrayOf<IntArray>(
        intArrayOf(android.R.color.holo_red_dark,R.drawable.book_icon),
        intArrayOf(android.R.color.holo_blue_dark,R.drawable.logo_secretaria),
        intArrayOf(android.R.color.holo_green_dark,R.drawable.ubi_icon),
        intArrayOf(android.R.color.holo_orange_dark,R.drawable.gear_icon),
    )

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        lateinit var img_view:ImageView
        lateinit var container:RelativeLayout

        init {
            img_view = itemView.findViewById(R.id.Frame1) as ImageView
            container = itemView.findViewById(R.id.contain) as RelativeLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_view.setImageResource(color_matrix[position][1])
        holder.container.setBackgroundResource(color_matrix[position][0])
    }

    override fun getItemCount(): Int {
        return color_matrix.size
    }

}