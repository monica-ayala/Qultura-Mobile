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
import com.example.qulturapp.model.galleries.Sala
import com.example.qulturapp.view.gallery.Gallery
import com.example.qulturapp.view.lounge.Lounge
import com.example.qulturapp.view.museum.Museum
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel
import com.squareup.picasso.Picasso

class GalleryListAdapter(private val data: List<Sala>, private val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    private val dataGalleryML = data.toMutableList()

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
            intent.putExtra("desc", item.desc_sala)
            intent.putExtra("nom", item.nom_sala)
            //intent.putExtra("ubi", item.ubi)
            intent.putExtra("url",item.img_sala)
            intent.putExtra("id",item.id_sala)

            context.startActivity(intent)
        }
        holder.salasImg.contentDescription = item.nom_sala
    }

    override fun getItemCount(): Int = dataGalleryML.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val salaNombre = view.findViewById(R.id.tv_sala_nom_item) as TextView
    val salasImg = view.findViewById(R.id.iv_sala_gallery) as ImageView

    val context = view.context

    fun bind(item: Sala) {
        salaNombre.text = item.nom_sala

        val ligaImg = "https://qulturaqro.live/uploads/museos/" + item.img_sala
        Picasso.get().load(ligaImg).into(salasImg);
    }
}

