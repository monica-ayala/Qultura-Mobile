package com.example.qulturapp.viewmodel.artworks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.artwork.ArtworkResults
import kotlinx.coroutines.launch

class ArtworkViewModel: ViewModel() {
    var listaArtwork: MutableLiveData<List<ArtworkResults>?> = MutableLiveData(listOf())

    private var caller: ApiCallerService = ApiCallerService()

    fun getObra(){

        viewModelScope.launch {
            val artworkList = caller.getObra()
            Log.d("Obras ---> ",artworkList!!.artwork.toString())
            val listaObras = mutableListOf<ArtworkResults>()
            for(obra in artworkList.artwork)
            {
                val content =  ArtworkResults(obra.nom_obra, obra.img_obra, obra.id_obra)
                listaObras.add(content)
            }

            listaArtwork.postValue(listaObras)
        }

    }

}