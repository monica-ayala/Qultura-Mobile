package com.example.qulturapp.model.eventos

import com.google.gson.annotations.SerializedName

data class Evento(
    @SerializedName("id_evento") val id_evento: Int,
    @SerializedName("info_evento") val info_evento: String,
    @SerializedName("fecha_hora_evento") val fecha_evento: String,
    @SerializedName("multimedia_evento") val multimedia_evento: String,
    @SerializedName("nombre_evento") val nombre_evento: String
    )
