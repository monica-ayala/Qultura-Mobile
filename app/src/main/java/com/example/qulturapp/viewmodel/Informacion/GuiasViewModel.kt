package com.example.qulturapp.viewmodel.Informacion

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.GuiaLista
import kotlinx.coroutines.launch

class GuiasViewModel: ViewModel() {
    var listaGuias = mutableListOf<Guia>()
    private var caller: ApiCallerService = ApiCallerService()

//    fun agregaGuia(){
//        val guia1 = Guia("Limitaciones Visuales", "Personas con dificultades visuales.", "No le tomes el baston. Mejor dile donde estan las cosas. Esto sera mejor. \n No le tomes el baston. Mejor dile donde estan las cosas. Esto sera mejor. \n \nNo le tomes el baston. Mejor dile donde estan las cosas. Esto sera mejor.", "https://cdn-icons-png.flaticon.com/512/159/159078.png", "https://www.inesem.es/revistadigital/educacion-sociedad/files/2016/11/ni%C3%B1os-con-discapacidad-visual-en-el-aula.jpg", "vFZZCfNONFw")
//        val guia2 = Guia("Limitaciones Motrices", "Personas que les cuestan algunos movimientos", "No le digas que haga cosas que no puede hacer por su discapacidad. Mejor dale alternativas\n\nNo le digas que haga cosas que no puede hacer por su discapacidad. Mejor dale alternativas\nNo le digas que haga cosas que no puede hacer por su discapacidad. Mejor dale alternativas", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Wheelchair_symbol.svg/898px-Wheelchair_symbol.svg.png", "https://mexico.unir.net/wp-content/uploads/sites/6/2021/12/alumnos_mx_3_id1216853241.jpg", "vFZZCfNONFw")
//        val guia3 = Guia("Limitaciones Cognitivas", "Personas con limitaciones en el funcionamiento intelectual", "No le digas comentarios ofensivos, o comentarios que puedan hacerlo sentir inferior. Alientalo a esforzarse lo mas que pueda.\n\nNo le digas comentarios ofensivos, o comentarios que puedan hacerlo sentir inferior. Alientalo a esforzarse lo mas que pueda.\nNo le digas comentarios ofensivos, o comentarios que puedan hacerlo sentir inferior. Alientalo a esforzarse lo mas que pueda.", "https://cdn-icons-png.flaticon.com/512/77/77306.png", "https://www.descubreme.cl/wp-content/uploads/2019/03/apoyo-DISCAPACIDAD-COGNITIVA-fundacion-descubreme.png", "vFZZCfNONFw")
//
//
//        listaGuias.add(guia1)
//        listaGuias.add(guia2)
//        listaGuias.add(guia3)
//    }

    fun agregaGuia(){
        viewModelScope.launch() {
            val guiaList = caller.searchGuiaList()

            Log.d("Nomms si sale",guiaList!!.guias[0].nombre_guia.toString())

        }
    }
}