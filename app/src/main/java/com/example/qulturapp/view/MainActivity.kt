package com.example.qulturapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.qulturapp.R
import com.example.qulturapp.view.sesion.ActivitySignIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

class MainActivity : AppCompatActivity() {

    private lateinit var musList:List<MuseumResults>

    //private lateinit var binding:ActivityMainBinding

    private lateinit var adapter:MuseumListAdapter


    /*private fun initializeList(list:List<MuseumResults>){
        adapter = MuseumListAdapter(list)
        var layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentSignIn = Intent(this, ActivitySignIn::class.java)
        //startActivity(intentSignIn)
        searchMuseumList()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ec2-3-145-68-44.us-east-2.compute.amazonaws.com:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchMuseumList(){

        CoroutineScope(Dispatchers.IO).launch {
        val call = getRetrofit().create(ApiService::class.java).getMuseumList("/get")
        val museumList = call.body()
        Log.d("Nomms si sale",museumList!!.museo.toString())
            /*val vista = findViewById(R.id.tvget) as TextView
            vista.text = museumList!!.museo.size.toString()*/
        }


    }

    /*private fun searchMuseumList(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getMuseumList("/get")
            val museumList = call.body()
            if(call.isSuccessful){
                //show Recyclerview
                Log.d("Salida",museumList!!.results.size.toString())
                musList = museumList.results

                CoroutineScope(Dispatchers.Main).launch { initializeList(musList) }


            }else{
                //show error
            }
        }
    }*/

}
