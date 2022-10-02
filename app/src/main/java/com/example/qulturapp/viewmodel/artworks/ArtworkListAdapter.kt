package com.example.qulturapp.viewmodel.artworks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ItemMuseumDetailBinding
import com.example.qulturapp.databinding.ItemObrasBinding
import com.example.qulturapp.model.artwork.ArtworkResults


class ArtworkListAdapter(private val data: List<ArtworkResults>, private val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    private val dataArtworkML = data.toMutableList()
    private val artworkViewModel = ArtworkViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_obras, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataArtworkML[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataArtworkML.size

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val obraNombre = view.findViewById(R.id.tvObraNom) as TextView

    val context = view.context

    fun bind(item: ArtworkResults) {
        obraNombre.text = item.name
    }
}

