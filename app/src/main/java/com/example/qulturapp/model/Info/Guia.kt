package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName
//Comment
data class Guia(
    @SerializedName("id_guia") val id_guia: Int,
    @SerializedName("nombre_guia") val nombre_guia: String,
    @SerializedName("desc_guia") val desc_guia: String,
    @SerializedName("icono_guia") val icono_guia: String,
    @SerializedName("video_guia") val video_guia: String,
    @SerializedName("tip_guia") val tip_guia: String,
    @SerializedName("imagen_guia") val imagen_guia: String
)
