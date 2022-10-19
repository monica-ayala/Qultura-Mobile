package com.example.qulturapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.viewmodel.list.ViewHolder

class ViewPagerAdapter(var context: Context): RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    var color_matrix = arrayOf<IntArray>(
        intArrayOf(android.R.color.holo_red_dark,R.drawable.manual1,R.string.PrimerManual),
        intArrayOf(android.R.color.holo_blue_dark,R.drawable.manual2,R.string.SegundoManual),
        intArrayOf(android.R.color.holo_green_dark,R.drawable.manual3,R.string.TecerManual),
        intArrayOf(android.R.color.holo_orange_dark,R.drawable.manual4,R.string.CuartoManual),
        intArrayOf(android.R.color.holo_purple,R.drawable.manual5,R.string.QuintoManual),

        )

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        lateinit var img_view:ImageView
        lateinit var container:RelativeLayout
        lateinit var txt_view:TextView

        init {
            img_view = itemView.findViewById(R.id.Frame1) as ImageView
            container = itemView.findViewById(R.id.contain) as RelativeLayout
            txt_view = itemView.findViewById(R.id.tvManual) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_view.setText(color_matrix[position][2])
        holder.img_view.setImageResource(color_matrix[position][1])
        holder.container.setBackgroundResource(color_matrix[position][0])
    }

    override fun getItemCount(): Int {
        return color_matrix.size
    }

}