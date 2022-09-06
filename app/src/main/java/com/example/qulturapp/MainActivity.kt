package com.example.qulturapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.solicitudes.Solicitud

class MainActivity : AppCompatActivity() {

    private var listaSolicitudes = mutableListOf<Solicitud>()
    private lateinit var adapter: SolicitudesListAdapter

    private fun agregaSolicitudes() {
        val solicitud1 = Solicitud("Museo de Arte", "3 de Abril", 2, 0)
        val solicitud2 = Solicitud("Museo de otras cosas", "5 de Mayo", 4, 0)
        listaSolicitudes.add(solicitud1)
        listaSolicitudes.add(solicitud2)
    }

    private fun initializeList(list:List<Solicitud>) {
        adapter = SolicitudesListAdapter(list)

        var layoutManager = LinearLayoutManager(this)
        val rvSolicitudes = findViewById<RecyclerView>(R.id.rv_list_solicitudes)
        rvSolicitudes.layoutManager = layoutManager
        rvSolicitudes.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_solicitudes)
        agregaSolicitudes()
        initializeList(listaSolicitudes.toList())
    }
}