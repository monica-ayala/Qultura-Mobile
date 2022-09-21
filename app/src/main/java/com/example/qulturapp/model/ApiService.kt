package com.example.qulturapp.model

import com.example.qulturapp.model.sesion.UsuarioListResults
import com.example.qulturapp.model.solicitudes.SolicitudListResults
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getSolicitudList(@Url url:String): Response<SolicitudListResults>

    @POST
    suspend fun deleteSolicitud(@Url url:String, @Body requestBody: RequestBody): Response<RequestBody>

    @POST
    suspend fun getUsuario(@Url url:String, @Body requestBody: RequestBody): Response<UsuarioListResults>
}