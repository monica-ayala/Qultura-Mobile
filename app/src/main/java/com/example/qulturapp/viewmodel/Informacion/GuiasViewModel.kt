package com.example.qulturapp.viewmodel.Informacion

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.Info.Guia

class GuiasViewModel: ViewModel() {
    var listaGuias = mutableListOf<Guia>()

    fun agregaGuia(){
        val guia1 = Guia("Limitaciones Visuales")
        val guia2 = Guia("Limitaciones Motrices")
        val guia3 = Guia("Limitaciones Cognitivas")

        listaGuias.add(guia1)
        listaGuias.add(guia2)
        listaGuias.add(guia3)
    }
}