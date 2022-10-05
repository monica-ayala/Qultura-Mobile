package com.example.qulturapp.viewmodel.museum

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.model.museums.Museo
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.model.sesion.UsuarioActual
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MuseumViewModel: ViewModel() {

    var museum: MutableLiveData<Museo> = MutableLiveData(null)


    private var caller: ApiCallerService = ApiCallerService()


    fun getMuseo(id_museo: Int) {

        viewModelScope.launch {

            val museu = caller.getMuseo(id_museo)
            Log.d("IDs: ", museu!!.id_museo.toString())

        }
    }

}