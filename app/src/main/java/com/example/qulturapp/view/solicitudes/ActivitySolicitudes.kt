package com.example.qulturapp.view.solicitudes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesListAdapter
import com.example.qulturapp.model.solicitudes.Solicitud
import com.example.qulturapp.viewmodel.solicitudes.SolicitudesViewModel

class ActivitySolicitudes: AppCompatActivity() {
    private val solicitudesViewModel = SolicitudesViewModel()
    private lateinit var adapter: SolicitudesListAdapter

    private fun initializeList(list:List<Solicitud>) {
        adapter = SolicitudesListAdapter(list, this)

        val layoutManager = LinearLayoutManager(this)
        val rvSolicitudes = findViewById<RecyclerView>(R.id.rv_list_solicitudes)
        rvSolicitudes.layoutManager = layoutManager
        rvSolicitudes.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_solicitudes)
        solicitudesViewModel.agregaSolicitudes()
        initializeList(solicitudesViewModel.listaSolicitudes.toList())
    }
}