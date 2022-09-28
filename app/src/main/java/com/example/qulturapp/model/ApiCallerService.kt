package com.example.qulturapp.model

import android.util.Log
import com.example.qulturapp.model.eventos.EventoListResults
import com.example.qulturapp.model.museums.MuseumListResults
import com.example.qulturapp.model.sesion.EncuentraUsuario
import com.example.qulturapp.model.sesion.UsuarioListResults
import com.example.qulturapp.model.sesion.UsuarioActual
import com.example.qulturapp.model.solicitudes.SolicitudListResults
import okhttp3.MediaType
import okhttp3.OkHttpClient
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

    private fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        return client
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
        val params = """
            {
            "us_correo":"$correo",
            "us_contrasenia":"$contrasenia"
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).getUsuario("/usuario/login_movil", requestBody)
        return call.body()
    }

    suspend fun agregarUsuario(nombre: String, correo: String, contrasenia: String): EncuentraUsuario? {
        val params = """
            {
            "us_nombre":"$nombre",
            "us_correo":"$correo",
            "us_password":"$contrasenia"
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).registraUsuario("/usuario/signup_movil", requestBody)
        return call.body()
    }

    suspend fun searchEventoList(): EventoListResults? {
        val call = getRetrofit().create(ApiService::class.java).getEventList("/evento/getAll")
        val eventosList = call.body()
        return eventosList
    }
}