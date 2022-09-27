package com.example.qulturapp.viewmodel.galleries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel


class GalleryListAdapter(private val data: List<GalleryResults>, private val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    private val dataGalleryML = data.toMutableList()
    private val galleryViewModel = GalleryViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_gallery_detail, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataGalleryML[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataGalleryML.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val salaNombre = view.findViewById(R.id.tv_sala_nom_item) as TextView

    val context = view.context

    fun bind(item: GalleryResults) {
        salaNombre.text = item.name
    }
}

