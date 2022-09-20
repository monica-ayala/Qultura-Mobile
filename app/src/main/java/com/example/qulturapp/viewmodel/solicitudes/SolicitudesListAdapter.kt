package com.example.qulturapp.viewmodel.solicitudes

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.solicitudes.SolicitudLista

class SolicitudesListAdapter (private val data:List<SolicitudLista>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_solicitud, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, position)
    }

}

class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val textMuseo = view.findViewById(R.id.tv_museum) as TextView
    val horario = view.findViewById(R.id.tv_horario) as TextView
    val estado = view.findViewById(R.id.tv_estado) as TextView
    val asistentes = view.findViewById(R.id.tv_personas) as TextView
    val botonCancelar = view.findViewById(R.id.cancel_button) as Button
    val listaNecesidadesIzq = view.findViewById(R.id.rl_checklist_left) as LinearLayout
    val listaNecesidadesDer = view.findViewById(R.id.rl_checklist_right) as LinearLayout

    val context = view.context

    fun bind(item: SolicitudLista, position:Int) {
        textMuseo.text = item.museo
        horario.text = item.fecha
        asistentes.text = "Personas: " + item.asistentes.toString()
        var pos = true


        for(necesidad in item.necesidades) {
            val nuevaOpcion = TextView(context)
            nuevaOpcion.text = "- " + necesidad
            nuevaOpcion.setTextColor(Color.parseColor("#838383"))
            nuevaOpcion.gravity = Gravity.CENTER
            if(pos)
                listaNecesidadesIzq.addView(nuevaOpcion)
            else
                listaNecesidadesDer.addView(nuevaOpcion)

            pos = !pos
        }

        if(item.estado == 0){
            estado.text = "Estatus: \n Aceptado"
        }
    }
}