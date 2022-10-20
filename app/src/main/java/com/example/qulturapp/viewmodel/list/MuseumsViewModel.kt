package com.example.qulturapp.viewmodel.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.model.museums.MuseumResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MuseumsViewModel: ViewModel() {
    var listaMuseum: MutableLiveData<List<MuseumResults>?> = MutableLiveData(listOf())

    private var caller: ApiCallerService = ApiCallerService()

    fun searchMuseumList(){

        viewModelScope.launch {

            val museumList = caller.searchMuseumList()
            //Log.d("Museos",museumList!!.museo.toString())
            val listaMuseos = mutableListOf<MuseumResults>()
            for(museo in museumList!!.museo)
            {
                val content =  MuseumResults(museo?.nom_museo, museo?.imgP_museo, museo.id_museo, museo?.desc_museo, museo?.ubicacion_museo)

                listaMuseos.add(content)
            }
            listaMuseum.postValue(listaMuseos)
        }

    }

}