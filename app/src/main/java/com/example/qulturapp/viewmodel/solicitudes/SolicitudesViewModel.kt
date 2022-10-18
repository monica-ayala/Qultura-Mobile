package com.example.qulturapp.viewmodel.solicitudes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.model.solicitudes.SolicitudLista
import kotlinx.coroutines.launch

class SolicitudesViewModel: ViewModel() {
    var listaSolicitudes: MutableLiveData< List<SolicitudLista> > = MutableLiveData(listOf())
    private var caller: ApiCallerService = ApiCallerService()
    var statusConexion: MutableLiveData<Boolean> = MutableLiveData(null)

    /*
    fun agregaSolicitudes() {
        val solicitud1 = SolicitudLista( 1, "nada", "3 de Abril", 2, 0, "Museo de Arte", listaEjemplo)
        val solicitud2 = SolicitudLista( 2, "nada", "5 de Mayo", 4, 0, "Museo de otras cosas", listaEjemplo)
        val solicitud3 = SolicitudLista( 3, "nada", "22 de Mayo", 1, 0, "Galería Querétaro", listaEjemplo)
        listaSolicitudes.add(solicitud1)
        listaSolicitudes.add(solicitud2)
        listaSolicitudes.add(solicitud3)
    } */

    fun agregaSolicitudes(){
        viewModelScope.launch {
            try {
                val solicitudList = caller.searchSolicitudList(UsuarioActual.id)
                val listaSolicitudesAct = mutableListOf<SolicitudLista>()
                //Convertims los datos de Solicitud a la clase SolicitudLista, la cuál ya guarda
                //la lista de necesidades que tiene cada una, esto para facilitar otros procesos
                solicitudList?.solicitudes?.forEach { solicitud ->
                    var listaNecesidades = mutableListOf<String>()
                    for (necesidad in solicitudList.necesidades) {
                        if (necesidad.id_solicitud == solicitud.id_solicitud)
                            listaNecesidades.add(necesidad.necesidad)
                    }
                    val anio = solicitud.fecha.subSequence(0, 4)
                    val mes = solicitud.fecha.subSequence(5, 7)
                    val dia = solicitud.fecha.subSequence(8, 10)
                    val nuevaSolicitud = SolicitudLista(
                        solicitud.id_solicitud,
                        solicitud.info_adicional,
                        "$dia/$mes/$anio",
                        solicitud.asistentes,
                        solicitud.estado,
                        solicitud.museo,
                        solicitud.imagen_museo,
                        listaNecesidades
                    )
                    listaSolicitudesAct.add(nuevaSolicitud)
                }
                listaSolicitudes.postValue(listaSolicitudesAct.toList())
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }

    fun eliminaSolicitud(id_solicitud: Int){
        viewModelScope.launch {
            try {
                caller.eliminaSolicitud(id_solicitud)
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }

}