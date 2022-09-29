package com.example.qulturapp.viewmodel.museums

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.museums.Obras
import kotlinx.coroutines.launch

class ObrasViewModel:ViewModel() {

    private lateinit var caller: ApiCallerService
    private var listaObra = MutableLiveData<List<Obras>>()


    fun onCreate() {
        caller = ApiCallerService()
    }

    fun searchObraList(){

        viewModelScope.launch {

            val obraList = caller.searchObraList()
            if (obraList != null) {
                listaObra.postValue(obraList.obras)
            }
        }

    }

}