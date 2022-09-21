package com.example.qulturapp.viewmodel.museums

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MuseumsViewModel: ViewModel() {

    private lateinit var caller: ApiCallerService


    fun onCreate() {
        caller = ApiCallerService()

    }

    fun searchMuseumList(){

        viewModelScope.launch {

            val museumList = caller.searchMuseumList()
            Log.d("Nomms si sale",museumList!!.museo.toString())
        }

    }

}