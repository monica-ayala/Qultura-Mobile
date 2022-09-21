package com.example.qulturapp.model

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.databinding.ItemGalleryDetailBinding
import com.example.qulturapp.databinding.ItemMuseumDetailBinding
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.model.museums.MuseumResults

class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val binding = ItemMuseumDetailBinding.bind(view)
    private val gbinding = ItemGalleryDetailBinding.bind(view)

    fun bind(item: MuseumResults){
        //binding.tvName.text = item.name
    }

    fun gbind(item: GalleryResults){
        //binding.tvName.text = item.name
    }
}