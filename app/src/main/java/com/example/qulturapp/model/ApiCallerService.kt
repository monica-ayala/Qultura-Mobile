package com.example.qulturapp.model

import com.example.qulturapp.model.galleries.GalleryListResults
import com.example.qulturapp.model.museums.MuseumListResults
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCallerService {
    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://ec2-3-145-68-44.us-east-2.compute.amazonaws.com:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun searchMuseumList(): MuseumListResults?{

            val call = getRetrofit().create(ApiService::class.java).getMuseumList("/get")
            val museumList = call.body()
            return museumList
            /*val vista = findViewById(R.id.tvget) as TextView
            vista.text = museumList!!.museo.size.toString()*/


    }

    suspend fun searchGalleryList(): GalleryListResults?{

        val call = getRetrofit().create(ApiService::class.java).getGalleryList("/sala/get")
        val galleryList = call.body()
        return galleryList
        /*val vista = findViewById(R.id.tvget) as TextView
        vista.text = museumList!!.museo.size.toString()*/


    }

}