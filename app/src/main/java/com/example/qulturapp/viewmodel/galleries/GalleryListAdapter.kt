package com.example.qulturapp.viewmodel.galleries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.museum.Lounge
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel
import com.squareup.picasso.Picasso

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

        holder.salasImg.setOnClickListener {
            val intent = Intent(context, Lounge::class.java)
            //intent.putExtra("id", item.id_museo)
            //intent.putExtra("desc", item.desc)
            intent.putExtra("nom", item.name)
            //intent.putExtra("ubi", item.ubi)
            intent.putExtra("url",item.url)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = dataGalleryML.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val salaNombre = view.findViewById(R.id.tv_sala_nom_item) as TextView
    val salasImg = view.findViewById(R.id.iv_sala_gallery) as ImageView

    val context = view.context

    fun bind(item: GalleryResults) {
        salaNombre.text = item.name

        val ligaImg = "https://qulturaqro.live/uploads/" + item.url
        Picasso.get().load(ligaImg).into(salasImg);
    }
}

