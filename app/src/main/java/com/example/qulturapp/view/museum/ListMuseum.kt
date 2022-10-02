package com.example.qulturapp.view.museum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.databinding.ActivityArtworkBinding
import com.example.qulturapp.databinding.ActivityListMuseumBinding
import com.example.qulturapp.databinding.ActivityMainBinding
import com.example.qulturapp.model.ViewHolderr
import com.example.qulturapp.model.museums.*
import com.example.qulturapp.view.Info.ActivityInfo
import com.example.qulturapp.view.configuracion.ActivityConfiguration
import com.example.qulturapp.view.eventos.EventoActivity
import com.example.qulturapp.view.mapas.ActivityMap
import com.example.qulturapp.viewmodel.museums.MAdapter
import com.smarteist.autoimageslider.SliderView
import org.osmdroid.views.overlay.milestones.MilestoneMeterDistanceLister


class ListMuseum : AppCompatActivity() {

    private lateinit var binding: ActivityListMuseumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMuseumBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mList = ArrayList<MModel>()
        mList.add(MModel("MAQRO","https://images4.alphacoders.com/890/890322.jpg"))
        mList.add(MModel("Galeria Libertad","https://wallpaperaccess.com/full/2339301.jpg"))
        mList.add(MModel("Bellas Artes","https://images7.alphacoders.com/408/thumb-1920-408645.jpg"))
        mList.add(MModel("Memoria y Tolerancia","https://wallpaper.dog/large/5529357.jpg"))
        mList.add(MModel("Museo Jumex","https://wallpapercave.com/wp/wp2186242.jpg"))

        val adapter = MAdapter(mList)

        binding.apply {
            carouoselRV.adapter = adapter
            //carouoselRV.set3DItem(true)
            carouoselRV.setAlpha(true)
            carouoselRV.setInfinite(true)
        }

        /*
        val museobtn = findViewById<View>(R.id.carouoselRV)
        museobtn.setOnClickListener{
            val intent = Intent(this, Museum::class.java)
            startActivity(intent)
        }
        */

        val mapabtn = findViewById<View>(R.id.mapbtn)
        mapabtn.setOnClickListener {
            val intent = Intent(this, ActivityMap::class.java)
            startActivity(intent)
        }

        val evenbtn = findViewById<View>(R.id.event_btn)
        evenbtn.setOnClickListener {
            val intent = Intent(this, EventoActivity::class.java)
            startActivity(intent)
        }

        val guiabtn = findViewById<View>(R.id.guias_btn)
        guiabtn.setOnClickListener {
            val intent = Intent(this, ActivityInfo::class.java)
            startActivity(intent)
        }

        val ajusbtn = findViewById<View>(R.id.conf_btn)
        ajusbtn.setOnClickListener {
            val intent = Intent(this, ActivityConfiguration::class.java)
            startActivity(intent)
        }

    }









    /*

    // on below line we are creating a variable
    // for our array list for storing our images.
    lateinit var imageUrl: ArrayList<TextList>
    //lateinit var textStr: ArrayList<String>

    // on below line we are creating
    // a variable for our slider view.
    lateinit var sliderView: SliderView

    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_museum)

        // on below line we are initializing our slier view.
        sliderView = findViewById(R.id.slider)

        // on below line we are initializing
        // our image url array list.
        imageUrl = ArrayList()
        //textStr = ArrayList()

        // on below line we are adding data to our image url array list.
        imageUrl.add(TextList("https://media-exp1.licdn.com/dms/image/C4D03AQE9bWyXBKnrFA/profile-displayphoto-shrink_800_800/0/1517557830238?e=2147483647&v=beta&t=3Aab3u38BaMG8mjIPOjbK0614w3eY2zMziigQWhGQRk","Museo"))
        imageUrl.add(TextList("https://www.101museos.com/cms101/assets/recintos/-0088-.jpg","MAQRO"))
        imageUrl.add(TextList("https://www.101museos.com/cms101/assets/recintos/-7417-alta-.jpg","Galeria Libertad"))

        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter( imageUrl)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        sliderView.scrollTimeInSec = 30

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()

        val btn = findViewById<View>(R.id.museoBtn)
        btn.setOnClickListener{
            val intent = Intent(this, Museum::class.java)
            startActivity(intent)
        }
        val evbtn: Button = findViewById<View>(R.id.eventbtn) as Button
        evbtn.setOnClickListener{
            val intent = Intent(this, EventoActivity::class.java)
            startActivity(intent)
        }



    }*/

}
