package com.example.qulturapp.viewmodel.galleries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.model.galleries.Sala
import kotlinx.coroutines.launch

class GalleryViewModel: ViewModel() {
    var listaGallery: MutableLiveData<List<Sala>?> = MutableLiveData(listOf())

    private var caller: ApiCallerService = ApiCallerService()

    fun searchGalleryList(idMuseo:Int){

        viewModelScope.launch {

            val galleryList = caller.getGallery(idMuseo)
            Log.d("Salas ---> ",galleryList!!.gallery.toString())
            val listaSalas = mutableListOf<GalleryResults>()
            for(sala in galleryList!!.gallery)
            {
                val content =  GalleryResults(sala.nom_sala, sala.img_sala, sala.id_sala)
                listaSalas.add(content)
            }

            listaGallery.postValue(galleryList.gallery)
        }

    }

}