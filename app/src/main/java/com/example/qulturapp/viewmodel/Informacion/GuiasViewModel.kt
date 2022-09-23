package com.example.qulturapp.viewmodel.Informacion

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.Info.Guia

class GuiasViewModel: ViewModel() {
    var listaGuias = mutableListOf<Guia>()

    fun agregaGuia(){
        val guia1 = Guia("Limitaciones Visuales", "Personas con dificultades visuales.", "No le tomes el baston. Mejor dile donde estan las cosas. Esto sera mejor.")
        val guia2 = Guia("Limitaciones Motrices", "Personas que les cuestan algunos movimientos", "No le digas que haga cosas que no puede hacer por su discapacidad. Mejor dale alternativas")
        val guia3 = Guia("Limitaciones Cognitivas", "Personas con limitaciones en el funcionamiento intelectual", "No le digas comentarios ofensivos, o comentarios que puedan hacerlo sentir inferior. Alientalo a esforzarse lo mas que pueda.")


        listaGuias.add(guia1)
        listaGuias.add(guia2)
        listaGuias.add(guia3)
    }
}