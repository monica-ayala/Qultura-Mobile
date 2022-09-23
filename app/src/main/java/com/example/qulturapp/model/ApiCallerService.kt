package com.example.qulturapp.model

import com.example.qulturapp.model.museums.MuseumListResults
import android.util.Log
import com.example.qulturapp.model.sesion.UsuarioListResults
import com.example.qulturapp.model.sesion.UsuarioActual
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

    suspend fun searchMuseumList(): MuseumListResults?{

            val call = getRetrofit().create(ApiService::class.java).getMuseumList("/get")
            val museumList = call.body()
            return museumList
            /*val vista = findViewById(R.id.tvget) as TextView
            vista.text = museumList!!.museo.size.toString()*/


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

    suspend fun agregaSolicitud(
        day_selected:String,
        monthYear_selected:String, hora_selected:String,
        numVisitantes:Int,
        info_adicional:String,
        necesidades: MutableList<Int>
    ) {
        Log.d("necesidades", necesidades.toString())
        val fecha_format = monthYear_selected + "-" + day_selected + " " + hora_selected + ":00"
        val UsuarioActual = UsuarioActual.id
        val params = """
            {
            "fecha_hora_sol":"$fecha_format",
            "num_Visitantes":$numVisitantes,
            "info_adicional":"$info_adicional",
            "necesidades":$necesidades,
            "usuario_necesidad":$UsuarioActual
            }
            """.trimIndent()
        Log.d("AAAAAAA",params)
        val requestBody =
            RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java)
            .agregaSolicitud("/solicitud/nuevaSolicitud", requestBody)
    }

    suspend fun searchUsuario(correo: String, contrasenia: String): UsuarioListResults? {
        Log.d("UHFOUDHIUSHFD", correo)
        val params = """
            {
            "us_correo":"$correo",
            "us_contrasenia":"$contrasenia"
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).getUsuario("/usuario/login_movil", requestBody)
        Log.d("UHFOUDHIUSHFDS", call.body().toString())
        return call.body()
    }
}