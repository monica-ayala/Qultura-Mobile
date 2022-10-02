package com.example.qulturapp.viewmodel.museums

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.MuseumResults

class MuseumListAdapter(private val data:List<MuseumResults>, private val context: Context) :RecyclerView.Adapter<ViewHolder>(){
    private val dataMuseumML = data.toMutableList()
    private val museumViewModel = MuseumsViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_museum_detail,parent,false)
        )
    }

    override fun getItemCount(): Int = dataMuseumML.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val museoNombre = view.findViewById(R.id.tvMusName) as TextView

    val context = view.context

    fun bind(item: MuseumResults) {
        museoNombre.text = item.name
    }
}



