package com.example.qulturapp.viewmodel.Informacion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.Info.GuiaLista
import com.example.qulturapp.model.Info.GuiasListResults
import kotlinx.coroutines.launch

class GuiasViewModel: ViewModel() {
    var listaGuias: MutableLiveData< List<GuiaLista> > = MutableLiveData(listOf())
    private var caller: ApiCallerService = ApiCallerService()

    fun agregaGuia(){
        viewModelScope.launch() {
            Log.d("ESTO ES UN TEST", "ESTO TAMBIEN EES UN TEST")
            val guiaList = caller.searchGuiaList()
            Log.d("Guias ---->",guiaList!!.guias.toString())
            val listGuias = mutableListOf<GuiaLista>()
            for(guia in guiaList.guias){
                val content = GuiaLista(guia.id_guia,  guia.video_guia,
                    guia.icono_guia, guia.nombre_guia, guia.tip_guia,
                    guia.imagen_guia, guia.desc_guia)
                listGuias.add(content)
            }
            listaGuias.postValue(listGuias)
        }
    }
}