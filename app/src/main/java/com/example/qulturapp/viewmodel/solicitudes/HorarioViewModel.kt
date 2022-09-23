package com.example.qulturapp.viewmodel.solicitudes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.horarios.Horario
import kotlinx.coroutines.launch

class HorarioViewModel: ViewModel() {
    private var caller: ApiCallerService = ApiCallerService()
    var listaHorario = mutableListOf<Horario>()

    var day_selected : String? = null
    var monthYear_selected : String? = null
    var hora_selected : String? = null
    var numVisitantes : String? = null
    var info_adicinal : String? = null
    var necesidades = arrayOf<Int>()

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


    fun agregaSolicitud(){
        viewModelScope.launch {
            day_selected?.let { monthYear_selected?.let { it1 ->
                hora_selected?.let { it2 ->
                    numVisitantes?.let { it3 ->
                        info_adicinal?.let { it4 ->
                            caller.agregaSolicitud(it, it1, it2, it3, it4,necesidades)
                        }
                    }
                }
            } }
        }
    }
}
