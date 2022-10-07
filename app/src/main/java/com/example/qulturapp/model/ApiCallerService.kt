package com.example.qulturapp.model

import android.util.Log
import com.example.qulturapp.model.Info.GuiasListResults
import com.example.qulturapp.model.Info.LinksListResults
import com.example.qulturapp.model.artwork.ArtworkListResults
import com.example.qulturapp.model.eventos.EventoListResults
import com.example.qulturapp.model.galleries.GalleryListResults
import com.example.qulturapp.model.galleries.Sala
import com.example.qulturapp.model.museums.Museo
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
            .baseUrl("http://3.14.37.4:8080")
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

    }

    suspend fun getMuseo(id_museo: Int): Museo?{

        val call = getRetrofit().create(ApiService::class.java).getOneMuseum("/museo/$id_museo/get")
        val museum = call.body()
        return museum

    }

    suspend fun getGallery(id_museo: Int): GalleryListResults?{
        val call = getRetrofit().create(ApiService::class.java).getOneGallery("sala/$id_museo/getSalas")
        val galleries = call.body()
        return galleries
    }

    suspend fun searchGalleryList(): GalleryListResults?{

        val call = getRetrofit().create(ApiService::class.java).getGalleryList("/sala/get")
        val galleryList = call.body()
        return galleryList
        /*val vista = findViewById(R.id.tvget) as TextView
        vista.text = museumList!!.museo.size.toString()*/


    }

    suspend fun searchSolicitudList(id_usuario: Int): SolicitudListResults?{
        val call = getRetrofit().create(ApiService::class.java).getSolicitudList("/solicitud/getAll/$id_usuario")
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
        day_selected: String,
        monthYear_selected: String, hora_selected: String,
        numVisitantes: Int,
        info_adicional: String,
        necesidades: MutableList<Int>,
        necesidades_text: MutableList<String>,
        id_museo: Int
    ) {
        val fecha_format = monthYear_selected + "-" + day_selected + " " + hora_selected + ":00"
        val UsuarioActual = UsuarioActual.id
        val params = """
            {
            "fecha_hora_sol":"$fecha_format",
            "num_Visitantes":$numVisitantes,
            "info_adicional":"$info_adicional",
            "necesidades":$necesidades,
            "usuario_necesidad":$UsuarioActual,
            "necesidades_text":$necesidades_text,
            "id_museo":$id_museo
            }
            """.trimIndent()
        val requestBody =
            RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
        val call = getRetrofit().create(ApiService::class.java)
            .agregaSolicitud("/solicitud/nuevaSolicitud", requestBody)
    }

    suspend fun searchUsuario(correo: String, contrasenia: String): UsuarioListResults? {
        val params = """
            {
            "us_correo":"$correo",
            "us_password":"$contrasenia"
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

    suspend fun getObra(): ArtworkListResults?{

        val call = getRetrofit().create(ApiService::class.java).getObra("/obra/get")
        val artworkList = call.body()
        return artworkList
    }

    suspend fun searchEventoList(): EventoListResults? {
        val call = getRetrofit().create(ApiService::class.java).getEventList("/evento/getAll")
        val eventosList = call.body()
        return eventosList
    }

    suspend fun searchGuiaList(): GuiasListResults? {
        val call = getRetrofit().create(ApiService::class.java).getGuiasList("/guias/getAll")
        val guiasList = call.body()
        return guiasList
    }

    suspend fun searchLinkList(): LinksListResults? {
        val call = getRetrofit().create(ApiService::class.java).getLinksList("/links/getAll")
        val linksList = call.body()
        return linksList
    }
}