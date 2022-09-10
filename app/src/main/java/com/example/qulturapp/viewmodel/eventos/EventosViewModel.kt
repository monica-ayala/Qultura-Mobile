package com.example.qulturapp.viewmodel.eventos

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.eventos.Evento

class EventosViewModel: ViewModel() {

    val listaEventos = mutableListOf<Evento>()


    fun agregarEvento (){
        val evento1 = Evento(1, "Evento de rock en la plaza de armas", "18/10/22", "https://amqueretaro.com/queretaro/2021/03/28/anuncian-evento-virtual-la-cultura-popular-e-indigena-de-queretaro-2021/", "Rock en querataro")
        val evento2 = Evento(2, "Evento de rock en la plaza de armas", "18/10/22", "https://amqueretaro.com/queretaro/2021/03/28/anuncian-evento-virtual-la-cultura-popular-e-indigena-de-queretaro-2021/", "Rock en querataro")
        val evento3 = Evento(3, "Evento de rock en la plaza de armas", "18/10/22", "https://amqueretaro.com/queretaro/2021/03/28/anuncian-evento-virtual-la-cultura-popular-e-indigena-de-queretaro-2021/", "Rock en querataro")
        listaEventos.add(evento1)
        listaEventos.add(evento2)
        listaEventos.add(evento3)
    }





}