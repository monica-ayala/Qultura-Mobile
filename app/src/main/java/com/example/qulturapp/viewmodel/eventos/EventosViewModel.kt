package com.example.qulturapp.viewmodel.eventos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.eventos.EventoListResults
import kotlinx.coroutines.launch

class EventosViewModel: ViewModel() {

    val caller = ApiCallerService()
    var listaEventos = MutableLiveData<EventoListResults?>()
    var statusConexion: MutableLiveData<Boolean> = MutableLiveData(null)

    /*
    fun agregarEvento (){
        val evento1 = Evento(1, "Evento de rock en la plaza de armas", "18/10/22", "https://amqueretaro.com/queretaro/2021/03/28/anuncian-evento-virtual-la-cultura-popular-e-indigena-de-queretaro-2021/", "Rock en querataro")
        val evento2 = Evento(2, "Sanctorum", "18/10/22", "https://pbs.twimg.com/media/FcodWemXoAEXIHF.jpg", "Sanctorum")
        val evento3 = Evento(3, "Cata de vino", "18/10/22", "https://billetto.co.uk/blog/wp-content/uploads/2019/05/kym-ellis-391585-unsplash-1024x683.jpg", "Catta de vinos")
        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
    } */

    fun agregarEventos() {
        viewModelScope.launch {
            try {
                val listEventos = caller.searchEventoList()
                listEventos.let {
                    listaEventos.postValue(listEventos)
                }
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }


}