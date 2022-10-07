package com.example.qulturapp.viewmodel.solicitudes

import com.example.qulturapp.viewmodel.solicitudes.HorarioViewModel
import android.content.Context
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
import com.example.qulturapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.model.horarios.Horario
import java.time.LocalDate

class CalendarAdapter(private val daysOfMonth:List<String>, private val con : Context, private val HorarioViewModel: HorarioViewModel, private val counter : Int, private val date : LocalDate): RecyclerView.Adapter<ViewHolderCalendario>() {

    var current_holder: ViewHolderCalendario? = null

    override fun onCreateViewHolder(parent:ViewGroup, viewType : Int) : ViewHolderCalendario {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_calendarcell,parent,false)
        return ViewHolderCalendario(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder:ViewHolderCalendario, position:Int) {
        holder.button_dayofMonth.text = daysOfMonth[position]
        if(holder.button_dayofMonth.text != " "){

            if(counter != 0 || (holder.button_dayofMonth.text.toString()).toInt() >= date.dayOfMonth){
                holder.button_dayofMonth.setOnClickListener{

                    if(current_holder != null){
                        current_holder!!.button_dayofMonth.setTextColor(ContextCompat.getColorStateList(con, R.color.black))
                        current_holder!!.button_dayofMonth.background = ContextCompat.getDrawable(con, R.drawable.calendar_unselected)

                    }
                    holder.button_dayofMonth.setTextColor(ContextCompat.getColorStateList(con, R.color.white))
                    holder.button_dayofMonth.background = ContextCompat.getDrawable(con, R.drawable.calendar_selected)

                    current_holder = holder

                    HorarioViewModel.day_selected = current_holder!!.button_dayofMonth.text as String
                }
            }else{
                holder.button_dayofMonth.setTextColor(ContextCompat.getColorStateList(con, R.color.gray_edit_box))
            }
        }
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }
}

class ViewHolderCalendario (itemView: View): RecyclerView.ViewHolder(itemView){
    var button_dayofMonth = itemView.findViewById(R.id.boton_cellday) as Button
}