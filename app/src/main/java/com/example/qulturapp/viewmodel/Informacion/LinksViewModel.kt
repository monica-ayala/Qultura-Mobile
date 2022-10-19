package com.example.qulturapp.viewmodel.Informacion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.Info.LinkLista
import kotlinx.coroutines.launch

class LinksViewModel: ViewModel() {
    var listaLinks: MutableLiveData< List<LinkLista> > = MutableLiveData(listOf())
    private var caller: ApiCallerService = ApiCallerService()

    fun agregaLink(){
        viewModelScope.launch() {
            Log.d("ESTO ES UN TEST LINK", "ESTO TAMBIEN EES UN TEST LINK")
            val linkList = caller.searchLinkList()
            Log.d("LINKS ---->",linkList!!.links.toString())
            val listLinks = mutableListOf<LinkLista>()
            for(link in linkList.links){
                val content = LinkLista(link.link, link.nombre_link)
                listLinks.add(content)
            }
            listaLinks.postValue(listLinks)
        }
    }
}