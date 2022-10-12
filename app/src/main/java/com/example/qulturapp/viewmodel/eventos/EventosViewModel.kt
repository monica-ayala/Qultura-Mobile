package com.example.qulturapp.viewmodel.eventos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.eventos.EventoListResults
import com.example.qulturapp.model.eventos.EventoLista
import com.example.qulturapp.model.solicitudes.SolicitudLista
import kotlinx.coroutines.launch

class EventosViewModel: ViewModel() {

    val caller = ApiCallerService()
    var listaEventos = MutableLiveData<List<EventoLista>>()
    var listaEventosFiltrados = MutableLiveData<List<EventoLista>>()
    var statusConexion: MutableLiveData<Boolean> = MutableLiveData(null)

    var filtrosTags = mutableListOf("Talleres", "Artes Escénicas", "Música", "Danza", "Aire Libre", "Cine", "Otros")

    fun agregarEventos() {
        viewModelScope.launch {
            try {
                val listEventos = caller.searchEventoList()
                val listaEventosAct = mutableListOf<EventoLista>()
                listEventos?.eventos?.forEach { evento ->
                    var listaTags = mutableListOf<String>()
                    for (tag in listEventos.tags) {
                        if (evento.id_evento == tag.id_evento)
                            listaTags.add(tag.nombre_tag)
                    }
                    val nuevoEvento = EventoLista(
                        evento.id_evento,
                        evento.info_evento,
                        evento.fecha_evento,
                        evento.multimedia_evento,
                        evento.ubicacion_evento,
                        listaTags
                    )
                    listaEventosAct.add(nuevoEvento)
                }
                listaEventos.postValue(listaEventosAct.toList())
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }

    fun actualizaLista() {
        var listaEventosAct = mutableListOf<EventoLista>()
        listaEventos.value?.forEach { evento ->
            if(evento.tags.any { it in filtrosTags}) {
                listaEventosAct.add(evento)
            }
        }
        listaEventosFiltrados.postValue(listaEventosAct.toList())
    }


}