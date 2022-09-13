package com.example.qulturapp.model

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

}