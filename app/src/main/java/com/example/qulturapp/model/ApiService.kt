package com.example.qulturapp.model

import com.example.qulturapp.model.galleries.GalleryListResults
import com.example.qulturapp.model.museums.MuseumListResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getMuseumList(@Url url:String): Response<MuseumListResults>

    @GET
    suspend fun getGalleryList(@Url url:String): Response<GalleryListResults>

}