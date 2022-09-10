package com.example.qulturapp.viewmodel.solicitudes

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.solicitudes.Solicitud


class SolicitudesListAdapter (private val data:List<Solicitud>, private val context: Context): RecyclerView.Adapter<ViewHolder>() {
    private val dataML = data.toMutableList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_solicitud, parent, false))
    }

    override fun getItemCount(): Int = dataML.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataML[position]
        holder.bind(item)

        holder.botonCancelar.setOnClickListener {
            val altertaCancelar = AlertDialog.Builder(context)
            altertaCancelar.setTitle("Cancelar solicitud")
            altertaCancelar.setMessage("¿Estás seguro de que quieres cancelar esta solicitud?")

            altertaCancelar.setPositiveButton("Si",
                DialogInterface.OnClickListener { dialog, _ ->
                    eliminaSolicitud(position)
                    dialog.cancel()
                })

            altertaCancelar.setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()
                })
            altertaCancelar.show()
        }
    }

    private fun eliminaSolicitud(position: Int) {
        dataML.removeAt(position);
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

}

class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val textMuseo = view.findViewById(R.id.tv_museum) as TextView
    val horario = view.findViewById(R.id.tv_horario) as TextView
    val estado = view.findViewById(R.id.tv_estado) as TextView
    val asistentes = view.findViewById(R.id.tv_personas) as TextView
    val botonCancelar = view.findViewById(R.id.cancel_button) as Button

    fun bind(item: Solicitud) {
        textMuseo.text = item.museo
        horario.text = item.fecha
        asistentes.text = "Personas: " + item.asistentes.toString()

        if(item.estado == 0){
            estado.text = "Estatus: \n Aceptado"
        }

    }
}