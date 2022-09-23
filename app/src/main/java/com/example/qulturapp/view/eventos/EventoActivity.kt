package com.example.qulturapp.view.eventos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Gallery
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.eventos.Evento
import com.example.qulturapp.model.solicitudes.Solicitud
//import com.example.qulturapp.viewmodel.eventos.EventosListAdapter
import com.example.qulturapp.viewmodel.eventos.EventosViewModel
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesListAdapter
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesViewModel

class EventoActivity: AppCompatActivity() {
    /*
    private val eventosViewModel = EventosViewModel()
    private lateinit var adapter: EventosListAdapter
    private fun initializeList(list:List<Evento>) {
        adapter = EventosListAdapter(list)

        val layoutManager = LinearLayoutManager(this)
        val rvEvento = findViewById<RecyclerView>(R.id.rv_list_eventos)
        rvEvento.layoutManager = layoutManager
        rvEvento.adapter = adapter

    }*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_eventos)

        val btn = findViewById<View>(R.id.Boton_evento)
        btn.setOnClickListener{
            val intent = Intent(this, EventoDetalle::class.java)
            startActivity(intent)
        }
    }


}