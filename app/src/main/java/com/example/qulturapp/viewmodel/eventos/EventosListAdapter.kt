package com.example.qulturapp.viewmodel.eventos

import android.content.Context
import android.content.Intent
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
import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.eventos.EventoDetalle
import com.squareup.picasso.Picasso


class EventosListAdapter (private val data:List<Evento>, private val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.foto_evento.setOnClickListener {
            iniciaDetalleEvento(item)
        }
        holder.botonEvento.setOnClickListener {
            iniciaDetalleEvento(item)
        }
    }

    private fun iniciaDetalleEvento(item: Evento) {
        val intentEvento = Intent(context, EventoDetalle::class.java)
        intentEvento.putExtra("nombre_evento", item.info_evento)
        intentEvento.putExtra("fecha_evento", item.fecha_evento)
        intentEvento.putExtra("img_evento", item.multimedia_evento)
        context.startActivity(intentEvento)
    }
}

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val botonEvento = view.findViewById(R.id.button_evento) as Button
        val foto_evento = view.findViewById(R.id.iv_event_icon) as ImageView

        fun bind(item: Evento) {
            botonEvento.text = item.info_evento

            val ligaImg = "http://3.14.37.4:8080/uploads/" + item.multimedia_evento
            Picasso.get().load(ligaImg).into(foto_evento);

        }
    }