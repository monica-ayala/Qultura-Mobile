package com.example.qulturapp.model

import android.util.Log
import com.example.qulturapp.model.museums.MuseumListResults
import com.example.qulturapp.model.sesion.EncuentraUsuario
import com.example.qulturapp.model.sesion.UsuarioListResults
import com.example.qulturapp.model.solicitudes.SolicitudListResults
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiCallerService {
    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://ec2-3-145-68-44.us-east-2.compute.amazonaws.com:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
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

    suspend fun searchUsuario(correo: String, contrasenia: String): UsuarioListResults? {
        val params = """
            {
            "us_correo":"$correo",
            "us_contrasenia":"$contrasenia"
            }
            """.trimIndent()
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java).getUsuario("/usuario/login_movil", requestBody)
        Log.d("COCOCOOSA", call.body().toString())
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
        Log.d("COCOCOOSA", call.body().toString())
        return call.body()
    }
}