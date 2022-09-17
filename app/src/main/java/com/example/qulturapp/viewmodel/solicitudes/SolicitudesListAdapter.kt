package com.example.qulturapp.viewmodel.solicitudes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.solicitudes.Solicitud

class SolicitudesListAdapter (private val data:List<Solicitud>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_solicitud, parent, false))
    }


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}

class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val textMuseo = view.findViewById(R.id.tv_museum) as TextView
    val horario = view.findViewById(R.id.tv_horario) as TextView
    val estado = view.findViewById(R.id.tv_estado) as TextView
    val asistentes = view.findViewById(R.id.tv_personas) as TextView

    fun bind(item: Solicitud) {
        textMuseo.text = item.museo
        horario.text = item.fecha
        asistentes.text = "Personas: " + item.asistentes.toString()

        if(item.estado == 0){
            estado.text = "Estatus: \n Aceptado"
        }

    }
}