package com.example.qulturapp.view.eventos

import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.eventos.EventoLista
import com.example.qulturapp.viewmodel.eventos.EventosListAdapter
import com.example.qulturapp.viewmodel.eventos.EventosViewModel

class EventoActivity: AppCompatActivity() {

    private val eventosViewModel = EventosViewModel()
    private lateinit var adapter: EventosListAdapter
    private lateinit var toggleTalleres: ToggleButton
    private lateinit var toggleArtesEscenicas: ToggleButton
    private lateinit var toggleMusica: ToggleButton
    private lateinit var toggleDanza: ToggleButton
    private lateinit var toggleAireLibre: ToggleButton
    private lateinit var toggleCine: ToggleButton
    private lateinit var toggleOtros: ToggleButton

    private fun mensajeErrorConexion() {
        Toast.makeText(applicationContext,"Ha ocurrido un error de conexión",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun initializeList(list:List<EventoLista>) {
        adapter = EventosListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvEvento = findViewById<RecyclerView>(R.id.rv_list_eventos)
        rvEvento.layoutManager = layoutManager
        rvEvento.adapter = adapter

    }

    private fun modificaFiltros(nombreTag: String, isChecked: Boolean) {
        if(isChecked) {
            eventosViewModel.filtrosTags.add(nombreTag)
        } else {
            eventosViewModel.filtrosTags.remove(nombreTag)
        }
        eventosViewModel.actualizaLista()
    }

    private fun initializeToggleListeners() {
        toggleTalleres.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Talleres", isChecked)
        }
        toggleArtesEscenicas.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Artes Escénicas", isChecked)
        }
        toggleMusica.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Música", isChecked)
        }
        toggleDanza.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Danza", isChecked)
        }
        toggleAireLibre.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Aire Libre", isChecked)
        }
        toggleCine.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Cine", isChecked)
        }
        toggleOtros.setOnCheckedChangeListener { _, isChecked ->
            modificaFiltros("Otros", isChecked)
        }
    }

    private fun initializeObservers() {
        eventosViewModel.listaEventos.observe(this, Observer { list ->
            if (list != null) {
                eventosViewModel.listaEventosFiltrados.postValue(list)
            }
        })
        eventosViewModel.listaEventosFiltrados.observe(this, Observer { list ->
            if (list != null) {
                initializeList(list)
            }
        })
        eventosViewModel.statusConexion.observe(this, Observer {
            if(it == false) {
                mensajeErrorConexion()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_eventos)
        toggleTalleres = findViewById(R.id.filtro_talleres)
        toggleArtesEscenicas = findViewById(R.id.filtro_artes_escenicas)
        toggleMusica = findViewById(R.id.filtro_musica)
        toggleDanza = findViewById(R.id.filtro_danza)
        toggleAireLibre = findViewById(R.id.filtro_aire_libre)
        toggleCine = findViewById(R.id.filtro_cine)
        toggleOtros = findViewById(R.id.filtro_otros)

        initializeObservers()
        initializeToggleListeners()

        eventosViewModel.agregarEventos()

        /*
        val btn = findViewById<View>(R.id.Boton_evento)
        btn.setOnClickListener{
            val intent = Intent(this, EventoDetalle::class.java)
            startActivity(intent)
        } */
    }


}