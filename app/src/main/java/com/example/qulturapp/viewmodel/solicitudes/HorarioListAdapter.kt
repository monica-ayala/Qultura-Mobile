package com.example.qulturapp.viewmodel.solicitudes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.qulturapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.model.horarios.Horario

class HorarioListAdapter (private val data:List<Horario>): RecyclerView.Adapter<ViewHolder_solicitudhorario>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_solicitudhorario {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder_solicitudhorario(layoutInflater.inflate(R.layout.item_horario_solicitud, parent,false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder_solicitudhorario, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}

class ViewHolder_solicitudhorario (view: View): RecyclerView.ViewHolder(view) {
    val textHorario = view.findViewById(R.id.tv_horario) as TextView

    fun bind(item: Horario) {
        textHorario.text = item.hora
    }
}
