package com.example.qulturapp.viewmodel.Informacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia

class GuiasListAdapter (private val data: List<Guia>, private val guiaItemClickListener:OnGuiaClickListener): RecyclerView.Adapter<GuiasListAdapter.ViewHolderGuias>() {

    interface OnGuiaClickListener{
        fun onGuiaClick(name: String, desc: String, tip: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGuias {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderGuias(layoutInflater.inflate(R.layout.item_guia, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderGuias, position: Int) {
        val itemGuia = data[position]
        holder.bindGuia(itemGuia)
    }

    inner class ViewHolderGuias (view: View): RecyclerView.ViewHolder(view){
        val nameGuia = view.findViewById(R.id.tv_guia_name) as TextView

        fun bindGuia(item: Guia){
            itemView.setOnClickListener { guiaItemClickListener.onGuiaClick(item.name, item.desc, item.tip) }
            nameGuia.text = item.name
        }
    }
}



