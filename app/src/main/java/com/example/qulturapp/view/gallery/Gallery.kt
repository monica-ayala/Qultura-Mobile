package com.example.qulturapp.view.gallery


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.viewmodel.galleries.GalleryListAdapter


class Gallery:AppCompatActivity() {
    private lateinit var adapter: GalleryListAdapter

    private fun initializeList(list:List<GalleryResults>) {
        adapter = GalleryListAdapter(list, this)
        val layoutManager = LinearLayoutManager(this)
        val rvGalleries = findViewById<RecyclerView>(R.id.rv_list_horarios)
        rvGalleries.layoutManager = layoutManager
        rvGalleries.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
    }
}