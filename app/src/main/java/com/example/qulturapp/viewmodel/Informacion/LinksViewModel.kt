package com.example.qulturapp.viewmodel.Informacion

import androidx.lifecycle.ViewModel
import com.example.qulturapp.model.Info.Link

class LinksViewModel: ViewModel() {
    var listaLinks = mutableListOf<Link>()

    fun agregaLink(){
        val link1 = Link("Secretaría de Cultura", "https://culturaqueretaro.gob.mx/iqca/sitio/")
        val link2 = Link("Museo de Arte Contemp", "https://macq.mx/visita/")

        listaLinks.add(link1)
        listaLinks.add(link2)
    }
}