package com.example.qulturapp.viewmodel.solicitudes

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.horarios.Horario

class HorarioViewModel: ViewModel() {
    var listaHorario = mutableListOf<Horario>()

    var day_selected : String? = null
    var monthYear_selected : String? = null
    var hora_selected : String? = null

    fun agregaHorarios() {
        val horario1 = Horario("09:00 AM")
        val horario2 = Horario("10:00 AM")
        val horario3 = Horario("11:00 AM")
        val horario4 = Horario("12:00 PM")
        val horario5 = Horario("13:00 PM")
        val horario6 = Horario("14:00 PM")
        val horario7 = Horario("15:00 PM")
        val horario8 = Horario("16:00 PM")
        val horario9 = Horario("17:00 PM")
        val horario10 = Horario("18:00 PM")
        listaHorario.add(horario1)
        listaHorario.add(horario2)
        listaHorario.add(horario3)
        listaHorario.add(horario4)
        listaHorario.add(horario5)
        listaHorario.add(horario6)
        listaHorario.add(horario7)
        listaHorario.add(horario8)
        listaHorario.add(horario9)
        listaHorario.add(horario10)

    }
}
