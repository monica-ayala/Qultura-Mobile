package com.example.qulturapp.viewmodel.solicitudes
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.qulturapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.model.horarios.Horario

class HorarioListAdapter (private val data:List<Horario>, private val con : Context, private val HorarioViewModel:HorarioViewModel): RecyclerView.Adapter<ViewHolder_solicitudhorario>() {

    var current_holder: ViewHolder_solicitudhorario? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_solicitudhorario {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder_solicitudhorario(layoutInflater.inflate(R.layout.item_horario_solicitud, parent,false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder_solicitudhorario, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.textHorario.setOnClickListener{

            if(current_holder != null){
                current_holder!!.textHorario.backgroundTintList = ContextCompat.getColorStateList(con, R.color.card_box_border)
            }

            holder.textHorario.backgroundTintList = ContextCompat.getColorStateList(con, R.color.secondary_color)

            current_holder = holder

            HorarioViewModel.hora_selected = current_holder!!.textHorario.text.toString()
        }

    }

}

class ViewHolder_solicitudhorario (view: View): RecyclerView.ViewHolder(view) {
    val textHorario = view.findViewById<Button>(R.id.boton_hora)

    fun bind(item: Horario) {
        textHorario.text = item.hora
    }
}
