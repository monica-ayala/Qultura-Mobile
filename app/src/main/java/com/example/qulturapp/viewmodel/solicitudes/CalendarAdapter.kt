package com.example.qulturapp.viewmodel.solicitudes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.qulturapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.model.horarios.Horario

class CalendarAdapter(private val daysOfMonth:List<String>, private val onItemListener:OnItemListener): RecyclerView.Adapter<ViewHolderCalendario>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType : Int) : ViewHolderCalendario {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_calendarcell,parent,false)
        //view.layoutParams.height = (parent.height * 0.5).toInt()
        return ViewHolderCalendario(view, onItemListener)
    }

    override fun onBindViewHolder(holder:ViewHolderCalendario, position:Int) {
        holder.tv_dayofMonth.text = daysOfMonth[position]
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    interface OnItemListener{
        fun onItemClick(position : Int, dayText : String){

        }

    }
}

class ViewHolderCalendario (itemView: View, private val onItemListener: CalendarAdapter.OnItemListener): RecyclerView.ViewHolder(itemView), View.OnClickListener{
    val tv_dayofMonth = itemView.findViewById(R.id.tv_cellday) as TextView

    override fun onClick(view : View) {
        onItemListener.onItemClick(bindingAdapterPosition, tv_dayofMonth.text as String)
    }
}