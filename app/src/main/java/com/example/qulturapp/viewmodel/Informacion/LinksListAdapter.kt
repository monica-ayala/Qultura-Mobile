package com.example.qulturapp.viewmodel.Informacion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.Link



class LinksListAdapter (private val data:List<Link>): RecyclerView.Adapter<ViewHolderLinks>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLinks {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderLinks(layoutInflater.inflate(R.layout.item_links, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderLinks, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}




