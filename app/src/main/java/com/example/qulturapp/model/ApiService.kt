package com.example.qulturapp.model

import com.example.qulturapp.model.solicitudes.SolicitudListResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getSolicitudList(@Url url:String): Response<SolicitudListResults>

}