package com.example.qulturapp.viewmodel.Informacion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.Link



class LinksListAdapter (private val data:List<Link>, private val linkItemClickListener:OnLinkClickListener): RecyclerView.Adapter<LinksListAdapter.ViewHolderLinks>() {

    interface OnLinkClickListener{
        fun onLinkClick(name: String, url: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLinks {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderLinks(layoutInflater.inflate(R.layout.item_links, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderLinks, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolderLinks (view: View): RecyclerView.ViewHolder(view){
        val textLink = view.findViewById(R.id.tv_link_name) as TextView
//    val nameGuia = view.findViewById(R.id.tv_guia_name) as TextView

        fun bind(item: Link){
            itemView.setOnClickListener { linkItemClickListener.onLinkClick(item.link, item.url) }
            textLink.text = item.link
        }
    }

}




