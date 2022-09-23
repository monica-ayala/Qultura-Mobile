package com.example.qulturapp.viewmodel.galleries

import GalleriesViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.ViewHolder
import com.example.qulturapp.model.galleries.GalleryResults

class GalleryListAdapter (private val data:List<GalleryResults>) : RecyclerView.Adapter<ViewHolderGallery>(){
    private val dataGalleryML = data.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGallery {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderGallery(layoutInflater.inflate(R.layout.item_gallery_detail, parent, false)
        )
    }

    override fun getItemCount(): Int = dataGalleryML.size

    override fun onBindViewHolder(holder: ViewHolderGallery, position: Int) {
        val item = dataGalleryML[position]
        holder.bind(item)
    }

}

class ViewHolderGallery(view: View) : RecyclerView.ViewHolder(view) {
    val salaNombre = view.findViewById(R.id.tv_sala_nom) as TextView

    val nomSala: TextView = itemView.findViewById(R.id.tv_sala_nom)
    fun bind(item: GalleryResults) {
        salaNombre.text = item.name
    }
}