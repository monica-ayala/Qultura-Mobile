package com.example.qulturapp.viewmodel.artworks

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ItemMuseumDetailBinding
import com.example.qulturapp.databinding.ItemObrasBinding
import com.example.qulturapp.model.artwork.ArtworkResults
import com.example.qulturapp.view.artwork.Artwork
import com.example.qulturapp.view.lounge.Lounge
import com.squareup.picasso.Picasso


class ArtworkListAdapter(private val data: List<ArtworkResults>, private val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    private val dataArtworkML = data.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_obras, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataArtworkML[position]
        holder.bind(item)

        holder.obraNombre.setOnClickListener {
            val intent = Intent(context, Artwork::class.java)
            intent.putExtra("nom", item.name)
            intent.putExtra("url", item.url)
            intent.putExtra("id", item.id_obra)
            intent.putExtra("desc", item.desc_obra)
            intent.putExtra("fecha", item.fecha_obra)
            intent.putExtra("autor", item.autor_obra)
            intent.putExtra("audio", item.audio_obra)

            context.startActivity(intent)
        }

        holder.obraNombre.contentDescription = item.name
    }

    override fun getItemCount(): Int = dataArtworkML.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val obraNombre = view.findViewById(R.id.tvObraNom) as TextView
    private val obraImg = view.findViewById(R.id.ivObra) as ImageView

    val context = view.context

    fun bind(item: ArtworkResults) {
        obraNombre.text = item.name

        val ligaImg = "https://qulturaqro.live/uploads/museos/" + item.url
        Picasso.get().load(ligaImg).into(obraImg);
    }
}

