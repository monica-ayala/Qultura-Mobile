package com.example.qulturapp.viewmodel.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.view.museum.Artwork
import com.example.qulturapp.view.museum.Museum

class MuseumListAdapter(private val data:List<MuseumResults>, private val context: Context) :RecyclerView.Adapter<ViewHolder>(){
    private val dataMuseumML = data.toMutableList()
    private val museumViewModel = MuseumsViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_museum_detail,parent,false)
        )
    }

    override fun getItemCount(): Int = dataMuseumML.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.museoImg.setOnClickListener {
            val intent = Intent(context, Museum::class.java)
            intent.putExtra("id", item.id_museo)
            intent.putExtra("desc", item.desc)
            intent.putExtra("nom", item.name)
            intent.putExtra("ubi", item.ubi)

            context.startActivity(intent)
        }

    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val museoNombre = view.findViewById(R.id.tvMusName) as TextView
    val museoImg = view.findViewById(R.id.ivMusImg) as ImageView

    val context = view.context

    fun bind(item: MuseumResults) {
        museoNombre.text = item.name
        Glide.with(museoImg).load(item.url).into(museoImg)
        item.id_museo
        item.name
        item.desc
        item.ubi

    }
}



