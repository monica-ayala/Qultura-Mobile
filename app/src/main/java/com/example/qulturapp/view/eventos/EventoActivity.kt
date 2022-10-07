package com.example.qulturapp.view.eventos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.viewmodel.eventos.EventosListAdapter
import com.example.qulturapp.viewmodel.eventos.EventosViewModel

class EventoActivity: AppCompatActivity() {

    private val eventosViewModel = EventosViewModel()
    private lateinit var adapter: EventosListAdapter

    private fun mensajeErrorConexion() {
        Toast.makeText(applicationContext,"Ha ocurrido un error de conexión",
            Toast.LENGTH_SHORT)
            .show()
    }

    private fun initializeList(list:List<Evento>) {
        adapter = EventosListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvEvento = findViewById<RecyclerView>(R.id.rv_list_eventos)
        rvEvento.layoutManager = layoutManager
        rvEvento.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_eventos)

        eventosViewModel.listaEventos.observe(this, Observer { list ->
                if (list != null) {
                    initializeList(list.eventos)
                }
        })
        eventosViewModel.statusConexion.observe(this, Observer {
            if(it == false) {
                mensajeErrorConexion()
            }
        })

        eventosViewModel.agregarEventos()

        /*
        val btn = findViewById<View>(R.id.Boton_evento)
        btn.setOnClickListener{
            val intent = Intent(this, EventoDetalle::class.java)
            startActivity(intent)
        } */
    }


}