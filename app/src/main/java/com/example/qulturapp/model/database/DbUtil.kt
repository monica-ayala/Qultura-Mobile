package com.example.qulturapp.model.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.Info.Guia
import com.example.qulturapp.model.artwork.Obra
import com.example.qulturapp.model.galleries.Sala
import com.example.qulturapp.model.museums.Museo
import com.example.qulturapp.view.artwork.Artwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DbUtil(private val context: Context) {
    private lateinit var db: QulturaDatabase
    private lateinit var qulturaDao: QulturaDatabaseDao
    private val caller = ApiCallerService()

    lateinit var listaMuseos: LiveData<List<MuseoR>>
    lateinit var listaSalas: LiveData<List<SalaR>>
    lateinit var listaObras: LiveData<List<ObraR>>
    lateinit var listaGuias: LiveData<List<GuiaR>>

    private suspend fun addObras(obras: List<Obra>) {
        obras.forEach{ obra ->
            val obraNueva = ObraR(
                obra.id_obra,
                obra.nom_obra,
                obra.audio_obra,
                obra.subtitulo_obra,
                obra.img_obra,
                obra.fecha_obra,
                obra.autor_obra,
                obra.desc_obra,
                obra.id_sala)

            qulturaDao.insertObra(obraNueva)
        }
    }

    private suspend fun addSalas(salas: List<Sala>) {
        salas.forEach{ sala ->
            val salaNueva = SalaR(
                sala.id_sala,
                sala.nom_sala,
                sala.audio_sala,
                sala.desc_sala,
                sala.img_sala,
                sala.status_sala,
                sala.id_museo_sala)

            qulturaDao.insertSala(salaNueva)
        }
    }

    private suspend fun addMuseos(museos: List<Museo>) {
        museos.forEach{ museo ->
            if(museo.nom_museo != null) {
                val museoNuevo = MuseoR(
                    museo.id_museo,
                    museo.nom_museo,
                    museo.desc_museo,
                    museo.ubicacion_museo,
                    museo.link_ubi,
                    museo.num_museo,
                    museo.imgP_museo,
                    museo.imgB_museo,
                    museo.status
                )

                qulturaDao.insertMuseo(museoNuevo)
            }
        }
    }

    private suspend fun addGuias(guias: List<Guia>) {
        guias.forEach{ guia ->
                val guiaNueva = GuiaR(
                    guia.id_guia,
                    guia.video_guia,
                    guia.desc_guia,
                    guia.icono_guia,
                    guia.nombre_guia,
                    guia.tip_guia,
                    guia.imagen_guia)

                qulturaDao.insertGuia(guiaNueva)
            }
    }

    fun initRoomDatabase(id_sala:Int){
        db = QulturaDatabase.getInstance(context)

        qulturaDao = db.qulturaDatabaseDao

        listaMuseos = qulturaDao.getAllMuseos()
        listaSalas = qulturaDao.getAllSalas()
        listaObras = qulturaDao.getAllObras()
        listaGuias = qulturaDao.getAllGuias()

        CoroutineScope(IO).launch {
            try {
                val salas = caller.searchGalleryList()
                val museos = caller.searchMuseumList()
                val obras = caller.getObra(id_sala)
                val guias = caller.searchGuiaList()

                qulturaDao.clearObras()
                qulturaDao.clearSalas()
                qulturaDao.clearMuseos()
                qulturaDao.clearGuias()

                museos?.let { addMuseos(it.museo) }
                salas?.let { addSalas(it.gallery) }
                obras?.let { addObras(it.artwork) }
                guias?.let { addGuias(it.guias) }
            } catch (e: Exception) { }

        }
    }

}