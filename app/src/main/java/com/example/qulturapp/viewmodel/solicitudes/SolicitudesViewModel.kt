package com.example.qulturapp.viewmodel.solicitudes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.model.solicitudes.SolicitudLista
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class SolicitudesViewModel: ViewModel() {
    var listaSolicitudes: MutableLiveData< List<SolicitudLista> > = MutableLiveData(listOf())
    private var caller: ApiCallerService = ApiCallerService()
    var statusConexion: MutableLiveData<Boolean> = MutableLiveData(null)

    fun agregaSolicitudes(){
        viewModelScope.launch {
            try {
                val solicitudList = caller.searchSolicitudList(UsuarioActual.id)
                val listaSolicitudesAct = mutableListOf<SolicitudLista>()
                //Convertimos los datos de Solicitud a la clase SolicitudLista, la cuál ya guarda
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
                    if(!esSolicitudPasada(nuevaSolicitud)) { //Solo agregar solicitudes "activas"
                        listaSolicitudesAct.add(nuevaSolicitud)
                    }
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

    //Permite revisar si la fecha de una solicitud ya pasó
    private fun esSolicitudPasada(solicitud: SolicitudLista): Boolean {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val calendarioInst = Calendar.getInstance()

        val fecha = calendarioInst.time
        val fechaCalendario = formatter.format(fecha) // Obtenemos la hora actual según el calendario

        val fechaActual: Date? = formatter.parse(fechaCalendario)
        val fechaSolicitud: Date? = formatter.parse(solicitud.fecha)

        //Verdadero en caso de que la fecha actual ya haya pasado la de la solicitud
        return (fechaActual?.after(fechaSolicitud) == true)

    }

}