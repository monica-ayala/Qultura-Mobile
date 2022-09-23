package com.example.qulturapp.viewmodel.museums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.Obras

class ObrasAdapter (private val obraList: List<Obras>): RecyclerView.Adapter<ObrasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObrasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ObrasViewHolder(layoutInflater.inflate(R.layout.item_obras, parent, false))
    }

    override fun onBindViewHolder(holder: ObrasViewHolder, position: Int) {
        val item = obraList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = obraList.size
}