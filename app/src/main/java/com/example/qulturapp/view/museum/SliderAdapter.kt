package com.example.qulturapp.view.museum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qulturapp.R
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.model.museums.TextList
import com.smarteist.autoimageslider.SliderViewAdapter


/*
// on below line we are creating a class for slider
// adapter and passing our array list to it.
class SliderAdapter(imageUrl: ArrayList<TextList>, /*textStr: ArrayList<String>*/) :
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    // on below line we are creating a
    // new array list and initializing it.
    var sliderList: ArrayList<TextList> = imageUrl
    //var sliderListText: ArrayList<String> = textStr


    // on below line we are calling get method
    override fun getCount(): Int {
        // in this method we are returning
        // the size of our slider list.
        return sliderList.size
    }

    // on below line we are calling on create view holder method.
    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        // inside this method we are inflating our layout file for our slider view.
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.slider_item, null)

        // on below line we are simply passing
        // the view to our slider view holder.
        return SliderViewHolder(inflate)
    }

    // on below line we are calling on bind view holder method to set the data to our image view.
    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {

        // on below line we are checking if the view holder is null or not.
        if (viewHolder != null) {
            // if view holder is not null we are simply
            // loading the image inside our image view using glide library
            Glide.with(viewHolder.itemView).load(sliderList.get(position).url).fitCenter()
                .into(viewHolder.imageView)
            viewHolder.textView.text = sliderList.get(position).title
            /*Glide.with(viewHolder.itemView).load(sliderList.get(position)).fitCenter()
                .into(viewHolder.textView)*/
        }
    }

    // on below line we are creating a class for slider view holder.
    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {

        // on below line we are creating a variable for our
        // image view and initializing it with image id.
        var imageView: ImageView = itemView!!.findViewById(R.id.myimage)
        var textView: TextView = itemView!!.findViewById(R.id.mytextimage)
    }
}*/
