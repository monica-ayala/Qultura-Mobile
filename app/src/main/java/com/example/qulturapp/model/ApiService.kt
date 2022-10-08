package com.example.qulturapp.model

import com.example.qulturapp.model.Info.GuiasListResults
import com.example.qulturapp.model.Info.LinksListResults
import com.example.qulturapp.model.artwork.ArtworkListResults
import com.example.qulturapp.model.eventos.EventoListResults
import com.example.qulturapp.model.galleries.GalleryListResults
import com.example.qulturapp.model.galleries.Sala
import com.example.qulturapp.model.museums.Museo
import com.example.qulturapp.model.museums.MuseumListResults
import com.example.qulturapp.model.museums.MuseumResults
import com.example.qulturapp.model.sesion.EncuentraUsuario
import retrofit2.Response
import com.example.qulturapp.model.sesion.UsuarioListResults
import com.example.qulturapp.model.solicitudes.SolicitudListResults
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.http.*

interface ApiService {

    @GET
    suspend fun getMuseumList(@Url url:String): Response<MuseumListResults>

    @GET
    suspend fun getGalleryList(@Url url:String): Response<GalleryListResults>

    @GET
    suspend fun getOneGallery(@Url url:String): Response<GalleryListResults>

    @GET
    suspend fun getSolicitudList(@Url url:String): Response<SolicitudListResults>

    @GET
    suspend fun getObra(@Url url:String): Response<ArtworkListResults>

    @POST
    suspend fun deleteSolicitud(@Url url:String, @Body requestBody: RequestBody): Response<RequestBody>

    @POST
    suspend fun agregaSolicitud(@Url url:String, @Body requestBody: RequestBody)

    @POST
    suspend fun getUsuario(@Url url:String, @Body requestBody: RequestBody): Response<UsuarioListResults>

    @POST
    suspend fun registraUsuario(@Url url:String, @Body requestBody: RequestBody): Response<EncuentraUsuario>

    @GET
    suspend fun getEventList(@Url url:String): Response<EventoListResults>

    @GET
    suspend fun getOneMuseum(@Url url:String): Response<Museo>

    @GET
    suspend fun getGuiasList(@Url url:String): Response<GuiasListResults>

    @GET
    suspend fun getLinksList(@Url url:String): Response<LinksListResults>

}