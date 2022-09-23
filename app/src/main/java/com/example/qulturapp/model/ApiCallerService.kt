package com.example.qulturapp.model

import com.example.qulturapp.model.solicitudes.SolicitudListResults
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiCallerService {
    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://ec2-3-145-68-44.us-east-2.compute.amazonaws.com:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    suspend fun searchSolicitudList(): SolicitudListResults?{
        val call = getRetrofit().create(ApiService::class.java).getSolicitudList("/solicitud/getAll")
        val solicitudList = call.body()
        return solicitudList
    }

    suspend fun eliminaSolicitud(id_solicitud: Int){
        val params = """
            {
            "id_solicitud":$id_solicitud
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).deleteSolicitud("/solicitud/cancelar", requestBody)
    }

    suspend fun agregaSolicitud(day_selected:String,monthYear_selected:String, hora_selected:String,numVisitantes:String,info_adicional:String,necesidades:Array<Int>){
        val fecha_format = monthYear_selected + "-" + day_selected + " " + hora_selected + ":00"
        val params = """
            {
            "fecha_hora_sol":$fecha_format
            "num_Visitantes":$numVisitantes
            "info_adicional"$info_adicional
            "necesidades"$necesidades
            "usuario_necesidad"$"UsuarioActual"
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).agregaSolicitud("/solicitud/nuevaSolicitud", requestBody)
    }
}