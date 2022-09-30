package com.example.qulturapp.model.museums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.ViewHolderr

class MuseumListAdapter (private val data:List<MuseumResults>) :RecyclerView.Adapter<ViewHolderr>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderr {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderr(layoutInflater.inflate(R.layout.item_museum_detail,parent,false))
    }

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: ViewHolderr, position: Int) {
            val item = data[position]
            holder.bind(item)
        }

}