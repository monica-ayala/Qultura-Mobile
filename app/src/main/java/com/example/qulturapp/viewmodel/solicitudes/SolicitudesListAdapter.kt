package com.example.qulturapp.viewmodel.solicitudes

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.solicitudes.SolicitudLista
import com.squareup.picasso.Picasso

class SolicitudesListAdapter (private val data:List<SolicitudLista>, private val context: Context): RecyclerView.Adapter<ViewHolder>() {
    private val dataML = data.toMutableList()
    private val solicitudesViewModel = SolicitudesViewModel()

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
                    eliminaSolicitud(item)
                    dialog.cancel()
                })

            altertaCancelar.setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()
                })
            altertaCancelar.show()
        }
    }

    private fun eliminaSolicitud(item: SolicitudLista) {
        val position = dataML.indexOf(item)
        solicitudesViewModel.eliminaSolicitud(dataML[position].id_solicitud)
        dataML.remove(item);
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
    val listaNecesidadesIzq = view.findViewById(R.id.rl_checklist_left) as LinearLayout
    val listaNecesidadesDer = view.findViewById(R.id.rl_checklist_right) as LinearLayout
    val imagenMuseo = view.findViewById(R.id.img_museum) as ImageView

    val context = view.context

    fun bind(item: SolicitudLista) {
        textMuseo.text = item.museo
        horario.text = item.fecha
        asistentes.text = "Personas: " + item.asistentes.toString()

        val ligaImg = "http://3.14.37.4:8080/uploads/" + item.imagen_museo
        Picasso.get().load(ligaImg).into(imagenMuseo);

        var pos = true
        listaNecesidadesDer.removeAllViews()
        listaNecesidadesIzq.removeAllViews()
        
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

        estado.text = when(item.estado){
            2 -> "Estatus: \n Aceptado"
            1 -> "Estatus: \n En proceso"
            else -> "Estatus: \n Negado"
        }
    }
}