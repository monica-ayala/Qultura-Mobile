package com.example.qulturapp.viewmodel.museums

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.Obras
import com.example.qulturapp.view.museum.Artwork
import com.example.qulturapp.view.museum.Gallery
import com.example.qulturapp.view.museum.ListMuseum

class ObrasAdapter (private val obraList: List<Obras>, private val context: Context): RecyclerView.Adapter<ObrasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObrasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ObrasViewHolder(layoutInflater.inflate(R.layout.item_obras, parent, false))
    }

    override fun onBindViewHolder(holder: ObrasViewHolder, position: Int) {
        val item = obraList[position]
        holder.render(item)
        holder.obranom.setOnClickListener {
            val intent = Intent(context, Artwork::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = obraList.size
}