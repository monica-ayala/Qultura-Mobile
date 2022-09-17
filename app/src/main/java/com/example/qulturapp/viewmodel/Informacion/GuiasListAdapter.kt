package com.example.qulturapp.viewmodel.Informacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.Info.Guia

class GuiasListAdapter (private val data: List<Guia>): RecyclerView.Adapter<ViewHolderGuias>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGuias {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderGuias(layoutInflater.inflate(R.layout.item_guia, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolderGuias, position: Int) {
        val itemGuia = data[position]
        holder.bindGuia(itemGuia)
    }
}



