package com.example.qulturapp.model

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.databinding.ItemMuseumDetailBinding
import com.example.qulturapp.model.MuseumResults

class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val binding = ItemMuseumDetailBinding.bind(view)

    fun bind(item: MuseumResults){
        //binding.tvName.text = item.name
    }
}