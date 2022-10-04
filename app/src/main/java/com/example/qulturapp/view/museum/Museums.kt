package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.view.Info.ActivityInfo
import com.example.qulturapp.view.configuracion.ActivityConfiguration
import com.example.qulturapp.view.mapas.ActivityMap
import com.example.qulturapp.viewmodel.museums.MuseumsViewModel
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import androidx.lifecycle.Observer
import com.example.qulturapp.viewmodel.museums.MuseumListAdapter

class Museums : AppCompatActivity() {
    private val museumsViewModel = MuseumsViewModel()
    private lateinit var adapter: MuseumListAdapter

    private fun initializeList(list:List<MuseumResults>) {
        adapter = MuseumListAdapter(list, this)

        val carouselRecyclerview = findViewById<CarouselRecyclerview>(R.id.carouoselRV)
        val carouselLayoutManager = carouselRecyclerview.getCarouselLayoutManager()
        carouselRecyclerview.layoutManager = carouselLayoutManager
        carouselRecyclerview.adapter = adapter

        carouselRecyclerview.setAlpha(true)
        carouselRecyclerview.setInfinite(true)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_museum)
        museumsViewModel.listaMuseum.observe(this, Observer {
            if (it != null) {
                initializeList(it)
            }
        })
        museumsViewModel.searchMuseumList()

        val mapabtn = findViewById<View>(R.id.mapbtn)
        mapabtn.setOnClickListener {
            val intent = Intent(this, ActivityMap::class.java)
            startActivity(intent)
        }

/*        val evenbtn = findViewById<View>(R.id.event_btn)
        evenbtn.setOnClickListener {
            val intent = Intent(this, EventoActivity::class.java)
            startActivity(intent)
        }*/

//        val guiabtn = findViewById<View>(R.id.guias_btn)
//        guiabtn.setOnClickListener {
//            val intent = Intent(this, ActivityInfo::class.java)
//            startActivity(intent)
//        }
//
//        val ajusbtn = findViewById<View>(R.id.conf_btn)
//        ajusbtn.setOnClickListener {
//            val intent = Intent(this, ActivityConfiguration::class.java)
//            startActivity(intent)
//        }
    }

}