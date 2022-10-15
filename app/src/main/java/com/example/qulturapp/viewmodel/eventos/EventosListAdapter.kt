package com.example.qulturapp.viewmodel.eventos

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.EventoLista
import com.example.qulturapp.view.eventos.EventoDetalle
import com.squareup.picasso.Picasso


class EventosListAdapter (private val data:List<EventoLista>, private val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.foto_evento.setOnClickListener {
            //iniciaDetalleEvento(item)
            holder.contenido_evento.visibility =
                if(holder.contenido_evento.visibility == View.GONE) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                val params: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(1000, 1500)
            holder.foto_evento.setLayoutParams(params)
        }
        holder.botonEvento.setOnClickListener {
            //iniciaDetalleEvento(item)
            holder.contenido_evento.visibility =
                if(holder.contenido_evento.visibility == View.GONE) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }

    private fun iniciaDetalleEvento(item: EventoLista) {
        val intentEvento = Intent(context, EventoDetalle::class.java)
        intentEvento.putExtra("nombre_evento", item.info_evento)
        intentEvento.putExtra("fecha_evento", item.fecha_evento)
        intentEvento.putExtra("lugar_evento", item.ubicacion_evento)
        intentEvento.putExtra("img_evento", item.multimedia_evento)
        context.startActivity(intentEvento)
    }

}

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val botonEvento = view.findViewById(R.id.button_evento) as Button
        var foto_evento = view.findViewById(R.id.iv_event_icon) as ImageView
        val contenido_evento = view.findViewById(R.id.info_evento) as TextView

        fun bind(item: EventoLista) {
            botonEvento.text = item.info_evento

            val ligaImg = "http://3.14.37.4:8080/uploads/" + item.multimedia_evento
            Picasso.get().load(ligaImg).into(foto_evento);

            val fecha = item.fecha_evento
            val lugar = item.ubicacion_evento

            val anio = fecha.subSequence(0, 4)
            val mes = fecha.subSequence(5, 7)
            val dia = fecha.subSequence(8, 10)

            contenido_evento.text = "$dia/$mes/$anio \n en $lugar"

        }
    }