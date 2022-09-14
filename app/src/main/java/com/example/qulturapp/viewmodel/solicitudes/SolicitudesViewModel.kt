package com.example.qulturapp.viewmodel.solicitudes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.solicitudes.Solicitud
import kotlinx.coroutines.launch

class SolicitudesViewModel: ViewModel() {
    var listaSolicitudes = mutableListOf<Solicitud>()
    val listaEjemplo = listOf("Silla de ruedas", "Guía por audio", "si", "otro: una cosa extra")
    private var caller: ApiCallerService = ApiCallerService()

    fun agregaSolicitudes() {
        val solicitud1 = Solicitud( 1, "nada", "3 de Abril", 2, 0, "Museo de Arte", listaEjemplo)
        val solicitud2 = Solicitud( 2, "nada", "5 de Mayo", 4, 0, "Museo de otras cosas", listaEjemplo)
        val solicitud3 = Solicitud( 3, "nada", "22 de Mayo", 1, 0, "Galería Querétaro", listaEjemplo)
        listaSolicitudes.add(solicitud1)
        listaSolicitudes.add(solicitud2)
        listaSolicitudes.add(solicitud3)
    }

    fun searchMuseumList(){
        viewModelScope.launch {

            val solicitudList = caller.searchSolicitudList()
        }
    }


}