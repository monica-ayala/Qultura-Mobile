package com.example.qulturapp.view.museum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.smarteist.autoimageslider.SliderView

class ListMuseum : AppCompatActivity() {

    // on below line we are creating a variable
    // for our array list for storing our images.
    lateinit var imageUrl: ArrayList<String>
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
        imageUrl =
            (imageUrl + "https://media-exp1.licdn.com/dms/image/C4D03AQE9bWyXBKnrFA/profile-displayphoto-shrink_800_800/0/1517557830238?e=2147483647&v=beta&t=3Aab3u38BaMG8mjIPOjbK0614w3eY2zMziigQWhGQRk") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://www.101museos.com/cms101/assets/recintos/-0088-.jpg") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://www.101museos.com/cms101/assets/recintos/-7417-alta-.jpg") as ArrayList<String>

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

    }

}
