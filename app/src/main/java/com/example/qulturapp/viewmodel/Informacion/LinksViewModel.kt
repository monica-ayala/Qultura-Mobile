package com.example.qulturapp.viewmodel.Informacion

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.Info.Link

class LinksViewModel: ViewModel() {
    var listaLinks = mutableListOf<Link>()

    fun agregaLink(){
        val link1 = Link("Secretaría de Cultura")
        val link2 = Link("Secretaría de Cultura")

        listaLinks.add(link1)
        listaLinks.add(link2)
    }
}