package com.example.qulturapp.view.museum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qulturapp.R
import com.smarteist.autoimageslider.SliderView

class ListMuseum : AppCompatActivity() {

    // on below line we are creating a variable
    // for our array list for storing our images.
    lateinit var imageUrl: ArrayList<String>

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

        // on below line we are adding data to our image url array list.
        imageUrl =
            (imageUrl + "https://colombiaestudia.com/wp-content/uploads/2022/01/Logo_CEART.png") as ArrayList<String>
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
