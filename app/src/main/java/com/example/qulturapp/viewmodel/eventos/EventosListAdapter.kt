package com.example.qulturapp.viewmodel.eventos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.solicitudes.Solicitud
import com.squareup.picasso.Picasso


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
        val botonEvento = view.findViewById(R.id.button_evento) as Button
        val foto_evento = view.findViewById(R.id.iv_event_icon) as ImageView

        fun bind(item: Evento) {
            botonEvento.text = item.info_evento

            val ligaImg = "http://ec2-3-145-68-44.us-east-2.compute.amazonaws.com:8080/uploads/" + item.multimedia_evento
            Picasso.get().load(ligaImg).into(foto_evento);

        }
    }