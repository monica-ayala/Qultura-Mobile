package com.example.qulturapp.viewmodel.solicitudes

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.solicitudes.Solicitud

class SolicitudesViewModel: ViewModel() {
    var listaSolicitudes = mutableListOf<Solicitud>()
    val listaEjemplo = listOf("Silla de ruedas", "Guía por audio", "si", "otro: una cosa extra")

    fun agregaSolicitudes() {
        val solicitud1 = Solicitud("Museo de Arte", "3 de Abril", 2, 0, listaEjemplo)
        val solicitud2 = Solicitud("Museo de otras cosas", "5 de Mayo", 4, 0, listaEjemplo)
        val solicitud3 = Solicitud("Galería Querétaro", "22 de Mayo", 1, 0, listaEjemplo)
        listaSolicitudes.add(solicitud1)
        listaSolicitudes.add(solicitud2)
        listaSolicitudes.add(solicitud3)
    }



}