package com.example.qulturapp.viewmodel.Informacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.GuiaLista

class GuiasListAdapter (private val data: List<GuiaLista>, private val guiaItemClickListener:OnGuiaClickListener): RecyclerView.Adapter<GuiasListAdapter.ViewHolderGuias>() {
    private val dataGuiaML = data.toMutableList()
    private val guiaViewModel = GuiasViewModel()


    interface OnGuiaClickListener{
        fun onGuiaClick(name: String, desc: String, tip: String, icon: String, video: String, imagen: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGuias {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderGuias(layoutInflater.inflate(R.layout.item_guia, parent, false))
    }

    override fun getItemCount(): Int = dataGuiaML.size

    override fun onBindViewHolder(holder: ViewHolderGuias, position: Int) {
        val itemGuia = dataGuiaML[position]
        holder.bindGuia(itemGuia)
    }

    inner class ViewHolderGuias (view: View): RecyclerView.ViewHolder(view){
        val nameGuia = view.findViewById(R.id.tv_guia_name) as TextView

        fun bindGuia(item: GuiaLista){
            itemView.setOnClickListener { guiaItemClickListener.onGuiaClick(item.nombre_guia, item.desc_guia, item.tip_guia, item.icono_guia, item.video_guia, item.imagen_guia) }
            nameGuia.text = item.nombre_guia
        }
    }
}



