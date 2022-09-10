package com.example.qulturapp.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.databinding.ItemMuseumDetailBinding

class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val binding = ItemMuseumDetailBinding.bind(view)

    fun bind(item:MuseumResults){
        //binding.tvName.text = item.name
    }
}