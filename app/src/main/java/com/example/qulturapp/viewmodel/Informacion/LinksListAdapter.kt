package com.example.qulturapp.viewmodel.Informacion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.Link
import com.example.qulturapp.model.Info.LinkLista


class LinksListAdapter (private val data:List<LinkLista>, private val linkItemClickListener:OnLinkClickListener): RecyclerView.Adapter<LinksListAdapter.ViewHolderLinks>() {
    private val dataLinkML = data.toMutableList()
    private val linkViewModel = LinksViewModel()


    interface OnLinkClickListener{
        fun onLinkClick(name: String, url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLinks {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderLinks(layoutInflater.inflate(R.layout.item_links, parent, false))
    }

    override fun getItemCount(): Int = dataLinkML.size

    override fun onBindViewHolder(holder: ViewHolderLinks, position: Int) {
        val item = dataLinkML[position]
        holder.bind(item)
    }

    inner class ViewHolderLinks (view: View): RecyclerView.ViewHolder(view){
        val textLink = view.findViewById(R.id.tv_link_name) as TextView

        fun bind(item: LinkLista){
            itemView.setOnClickListener { linkItemClickListener.onLinkClick(item.link, item.nombre_link) }
            textLink.text = item.nombre_link
        }
    }
}




