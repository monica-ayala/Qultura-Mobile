package com.example.qulturapp.viewmodel.Informacion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.infoLinks.Link



class LinksListAdapter (private val data:List<Link>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_links, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}

class ViewHolder (view: View): RecyclerView.ViewHolder(view){
    val textLink = view.findViewById(R.id.tv_link_name) as TextView

    fun bind(item: Link){
        textLink.text = item.link
    }
}