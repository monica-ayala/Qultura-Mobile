package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class Solicitud(
    @SerializedName("id_solicitud") val id_solicitud: Int,
    @SerializedName("info_adicional") val info_adicional: String,
    @SerializedName("fecha_hora") val fecha: String,
    @SerializedName("num_asistentes") val asistentes: Int,
    @SerializedName("status") val estado: Int,
    @SerializedName("nom_museo") val museo: String,
    @SerializedName("id_user_solicitud") val usuario: Int
)
