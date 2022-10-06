package com.example.qulturapp.view.gallery


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qulturapp.R
import com.example.qulturapp.model.galleries.GalleryResults
import com.example.qulturapp.viewmodel.galleries.GalleryListAdapter
import com.example.qulturapp.viewmodel.galleries.GalleryViewModel
import com.squareup.picasso.Picasso


class Gallery:AppCompatActivity() {
    private val galleryViewModel = GalleryViewModel()
    private lateinit var adapter: GalleryListAdapter


    private fun initializeList(list:List<GalleryResults>) {
        adapter = GalleryListAdapter(list, this)

        val layoutManager = GridLayoutManager(this, 2)
        val rvGalleries = findViewById<RecyclerView>(R.id.rv_list_salas)
        rvGalleries.layoutManager = layoutManager
        rvGalleries.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val idMuseo = intent.getIntExtra("id", 0)
        val imgMuseo = intent.getStringExtra("url")

        val salaBgImg = findViewById<ImageView>(R.id.profile_image)
        val museumImg = "https://qulturaqro.live/uploads/" + imgMuseo
        //Picasso.get().load(museumImg).into(salaBgImg)

        galleryViewModel.listaGallery.observe(this, Observer {
            if (it != null) {
                initializeList(it)
            }
        })
        galleryViewModel.searchGalleryList(idMuseo)
    }
}




