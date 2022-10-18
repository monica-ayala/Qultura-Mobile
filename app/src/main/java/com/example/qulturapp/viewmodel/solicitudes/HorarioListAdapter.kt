package com.example.qulturapp.viewmodel.solicitudes
import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.qulturapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.model.horarios.Horario
import com.example.qulturapp.view.solicitudes.ActivitySolicitudes
import java.time.LocalDate
import java.time.LocalDateTime

class HorarioListAdapter (private val data:List<Horario>, private val con : Context, private val owner : LifecycleOwner,  private val HorarioViewModel:HorarioViewModel, private val counter : Int): RecyclerView.Adapter<ViewHolder_solicitudhorario>() {

    var current_holder: ViewHolder_solicitudhorario? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_solicitudhorario {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder_solicitudhorario(layoutInflater.inflate(R.layout.item_horario_solicitud, parent,false))
    }

    override fun getItemCount(): Int = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder_solicitudhorario, position: Int) {
        val item = data[position]
        holder.bind(item)
        val hour = LocalDateTime.now()

            if(HorarioViewModel.fecha_check.value == 0) {
                holder.textHorario.setOnClickListener{
                    val toast = Toast.makeText(con, "Selecciona una fecha", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }else{
                if(HorarioViewModel.day_selected == (hour.dayOfMonth).toString() && counter == 0){
                    if(holder.textHorario.text.toString().take(2).toInt() > hour.hour){
                        holder.textHorario.setOnClickListener{

                            if(current_holder != null){
                                current_holder!!.textHorario.backgroundTintList = ContextCompat.getColorStateList(con, R.color.card_box_border)
                            }

                            holder.textHorario.backgroundTintList = ContextCompat.getColorStateList(con, R.color.secondary_color)

                            current_holder = holder

                            HorarioViewModel.hora_selected = current_holder!!.textHorario.text.toString()
                        }
                    }else{
                        holder.textHorario.setOnClickListener{
                            val toast = Toast.makeText(con, "Hora invalida", Toast.LENGTH_SHORT)
                            toast.show()
                        }
                    }
                }else {
                    holder.textHorario.setOnClickListener {

                        if (current_holder != null) {
                            current_holder!!.textHorario.backgroundTintList =
                                ContextCompat.getColorStateList(con, R.color.card_box_border)
                        }

                        holder.textHorario.backgroundTintList =
                            ContextCompat.getColorStateList(con, R.color.secondary_color)

                        current_holder = holder

                        HorarioViewModel.hora_selected =
                            current_holder!!.textHorario.text.toString()
                    }
                }
            }
    }
}

class ViewHolder_solicitudhorario (view: View): RecyclerView.ViewHolder(view) {
    val textHorario = view.findViewById<Button>(R.id.boton_hora)

    fun bind(item: Horario) {
        textHorario.text = item.hora
    }
}
