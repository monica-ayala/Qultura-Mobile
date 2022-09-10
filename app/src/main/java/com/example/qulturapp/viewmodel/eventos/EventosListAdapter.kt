package com.example.qulturapp.viewmodel.eventos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.solicitudes.Solicitud


class EventosListAdapter (private val data:List<Evento>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val nombre_evento = view.findViewById(R.id.nombre_evento) as TextView
        val foto_evento = view.findViewById(R.id.iv_event_icon) as ImageView

        fun bind(item: Evento) {
            nombre_evento.text = item.nombre_evento

        }
    }

